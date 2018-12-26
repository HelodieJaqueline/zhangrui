package com.zhangrui.annotation;

import java.lang.annotation.*;

/**
 * @Author: ZhangRui
 * @Date: Created at 2018-12-25-16:51
 * @Description:
 * @Modified: By
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLog {

	String params() default "";
}
