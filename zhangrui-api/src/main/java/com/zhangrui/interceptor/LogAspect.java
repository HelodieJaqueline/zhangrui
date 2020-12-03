package com.zhangrui.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志打印
 * @author zhangrui
 * @date 2020年8月31日
 */
@Component
@Aspect
@Slf4j
@Order(0)
public class LogAspect {

    /**
     * 默认日期时间格式化形式
     */
    private static final String DEFAULT_DATA_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Pointcut("execution(public * com.zhangrui.*.controller..*.*(..))")
    public void controllerLayer() {
        // controller切面
    }

    @Pointcut("@within(com.zhangrui.annotation.log.AopLog) || @annotation(com.zhangrui.annotation.log.AopLog)")
    public void logLayer() {
        // AopLog注解切面
    }

    @Around("controllerLayer()")
    public Object logInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodJp = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodJp.getMethod();
        Map<String, Object> paramMap = new HashMap<>();
        long start = System.nanoTime();
        StringBuffer requestLog = new StringBuffer();
        requestLog.append("REQUEST: ").append(", CLASS_METHOD = ")
            .append(proceedingJoinPoint.getSignature().getDeclaringTypeName())
            .append(" ").append(method.getName());
        String[] paramNames = methodJp.getParameterNames();
        Object[] params = proceedingJoinPoint.getArgs();
        if (ArrayUtils.isNotEmpty(paramNames)) {
            for (int i = 0; i < paramNames.length; i++) {
                if (params[i] instanceof ServletRequest || params[i] instanceof ServletResponse) {
                    continue;
                }
                paramMap.put(paramNames[i], JSON.toJSONString(params[i]));
            }
            requestLog.append(", ARGS = ").append(paramMap);
        }
        log.info(requestLog.toString());

        // 切面的方法运行
        Object response = null;
        try {
            response = proceedingJoinPoint.proceed();
        } finally {
            log.info("RESPONSE: , CLASS_METHOD = {}, RESULT = {}, USE :{}MS",
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " + method.getName(),
                JSON.toJSONStringWithDateFormat(response, DEFAULT_DATA_TIME_FORMAT,
                    SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.IgnoreErrorGetter,
                    SerializerFeature.DisableCircularReferenceDetect),
                (System.nanoTime() - start) / 1000000);
        }
        return response;
    }

    @Around("logLayer()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodJp = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodJp.getMethod();
        Map<String, Object> paramMap = new HashMap<>();
        long start = System.nanoTime();
        StringBuffer requestLog = new StringBuffer();
        requestLog.append("START CLASS_METHOD: ").append(proceedingJoinPoint.getSignature().getDeclaringTypeName())
            .append(" ").append(method.getName());

        String[] paramNames = methodJp.getParameterNames();
        Object[] params = proceedingJoinPoint.getArgs();
        if (ArrayUtils.isNotEmpty(paramNames)) {
            for (int i = 0; i < paramNames.length; i++) {
                paramMap.put(paramNames[i], JSON.toJSONString(params[i]));
            }
            requestLog.append(", PARAMETER: ").append(paramMap);
        }

        log.info(requestLog.toString());

        // 切面的方法运行
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } finally {
            log.info("END RESULT: {}, CLASS_METHOD = {}, USE TIME: {} MS",
                JSON.toJSONStringWithDateFormat(result, DEFAULT_DATA_TIME_FORMAT,
                    SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.IgnoreErrorGetter,
                    SerializerFeature.DisableCircularReferenceDetect),
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " + method.getName(),
                (System.nanoTime() - start) / 1000000);
        }
        return result;
    }
}
