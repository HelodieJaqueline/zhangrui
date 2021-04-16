package com.zhangrui.interceptor.aop;

import com.zhangrui.interceptor.annotation.AopLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangRui
 * @Date: Created at 2018-11-09-10:51
 * @Description:
 * @Modified: By
 */
@Aspect
@Component
@Slf4j
public class ApiLogAop {

	private static final String SPLIT_CHAR = ",";

	@Pointcut("@within(org.springframework.stereotype.Controller)")
	private void controllerAspect() {
	}

	@Pointcut("@within(com.zhangrui.interceptor.annotation.AopLog)")
	private void logLayer() {
	}

	@Around("controllerAspect() || logLayer()")
	public Object logger(ProceedingJoinPoint jp) throws Throwable {
		Long enterTime = System.currentTimeMillis();
		org.slf4j.Logger log = LoggerFactory.getLogger(jp.getTarget().getClass());
		printEnterLog(jp, log);
		Object result = jp.proceed();
		Long exitTime = System.currentTimeMillis();
		Long spendTime = exitTime - enterTime;
		printExitLog(jp, log, spendTime);
		return result;
	}

	/**
	 * <记录出方法日志>
	 * @param jp
	 * @see [类、类#方法、类#成员]
	 */
	private void printExitLog(ProceedingJoinPoint jp, org.slf4j.Logger logger, Long spendTime) {
		// 拼接出方法日志
		StringBuilder sb = new StringBuilder();
		sb.append("Exit  ");
		sb.append(jp.getTarget().getClass().getName());
		sb.append(".").append(jp.getSignature().getName());
		sb.append(" consume time ").append(spendTime).append(" ms");
		logger.info(sb.toString());
	}

	/**
	 * <记录入方法日志>
	 * @param jp
	 * @see [类、类#方法、类#成员]
	 */
	private void printEnterLog(ProceedingJoinPoint jp, org.slf4j.Logger logger) {
		Object[] params = jp.getArgs();
		// 拼接入方法日志
		StringBuilder sb = new StringBuilder();
		sb.append("Enter ");
		sb.append(jp.getTarget().getClass().getName());
		sb.append(".").append(jp.getSignature().getName()).append(" ");
		MethodSignature methodjp = (MethodSignature)jp.getSignature();
		AopLog logPointCut = methodjp.getMethod().getAnnotation(AopLog.class);
		String[] paramsNames = methodjp.getParameterNames();
		if (logPointCut != null && StringUtils.isNotEmpty(logPointCut.params())) {
			paramsNames = logPointCut.params().split(SPLIT_CHAR);
		}
		if (ArrayUtils.isNotEmpty(paramsNames)) {
			for (String paramsName : paramsNames) {
				sb.append(paramsName);
				sb.append("={}").append(",");
			}
		}
		logger.info(sb.toString(), params);
	}
}
