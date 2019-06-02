package com.whhx.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: jiangwei
 * @Date: 2019-06-02
 * @Desc:
 */
@Component
public class SpringContextBeanService implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }


    public static <T> T getBean(Class<T> beanClass) {
        return (T) context.getBean(beanClass);
    }

}
