package com.zhangrui.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationObjectSupport;

/**
 * @author XuSemon
 *
 */
@Component
public class SpringBeanProxy extends WebApplicationObjectSupport {

	private static ApplicationContext applicationContext;

    @Override
    protected void initApplicationContext(ApplicationContext context) {
        super.initApplicationContext(context);
        if(applicationContext == null){
            applicationContext = context;
        }
    }
	
    /**
     * 获取bean的方法 
     * @param <T>
     * @param clazz
     * @param beanName
     * @return
     */
    public static <T> T getBean(Class<T> clazz, String beanName){
    	Object o = applicationContext.getBean(beanName);
    	if(o!=null){
    		return clazz.cast(o);
    	}
    	return null;
    }
	
	public static Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}
}