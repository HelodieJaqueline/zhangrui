package com.zhangrui.interceptor.aop;

import com.zhangrui.interceptor.annotation.RedisDistLock;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 基于Redisson的分布式锁切面
 * @author: ZhangRui
 * @create: 2020-01-09 10:32
 **/
@Aspect
@Component
@Slf4j
public class RedisDistLockAop {

	@Autowired
	private RedissonClient redissonClient;

	@Pointcut("@annotation(com.zhangrui.interceptor.annotation.RedisDistLock)")
	private void lockLayer() {
	}

	@Around("lockLayer()")
	public Object execute(ProceedingJoinPoint jp) throws Throwable {
		MethodSignature signature = (MethodSignature) jp.getSignature();
		if (null != signature) {
			Method method = signature.getMethod();
			if (null != method) {
				//执行加锁操作
				return lock(jp,method.getAnnotation(RedisDistLock.class));
			}
		}
		return jp.proceed();
	}

	private Object lock(ProceedingJoinPoint jp, RedisDistLock redisDistLock) throws Throwable {
		RLock lock = redissonClient.getLock(redisDistLock.key());
		return redisDistLock.releaseWithTime() ? doLock(jp, lock, redisDistLock.leaseTime(), redisDistLock.unit())
			: doLock(jp, lock);
	}

	/**
	 * 带超时的锁
	 * @param jp
	 * @param lock
	 * @param leaseTime
	 * @param unit
	 * @return
	 * @throws Throwable
	 */
	private Object doLock(ProceedingJoinPoint jp, RLock lock, long leaseTime, TimeUnit unit) throws Throwable {
		lock.lock(leaseTime, unit);
		return doProceedAndUnlock(jp, lock);
	}


	/**
	 * 一直持有锁直到执行释放锁的操作
	 * @param jp
	 * @param lock
	 * @return
	 * @throws Throwable
	 */
	private Object doLock(ProceedingJoinPoint jp, RLock lock) throws Throwable {
		lock.lock();
		return doProceedAndUnlock(jp, lock);
	}

	private Object doProceedAndUnlock(ProceedingJoinPoint jp, RLock lock) throws Throwable {
		try {
			return jp.proceed();
		} finally {
			if (lock.isLocked()) {
				lock.unlock();
			}
		}
	}
}
