package com.ejet.bi.dynamicservice.comm;

import com.ejet.context.CoApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DynamicBeanFactory
 * Author:   Ejet
 * CreateDate:     2018-10-04 10:09
 * Description: 动态bean构造
 * History:
 * Version: 1.0
 */
public class DynamicBeanFactory {

    private static Logger logger = LoggerFactory.getLogger(DynamicBeanFactory.class);
    /**
     * 保存已经动态注册的bean对象
     */
    private static Map<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * 默认单态
     */
    public final static String SCOPE_SINGLETON = "singleton";

    public static BeanDefinitionBuilder genericBeanDefinition(Class clazz, final Map<String, Object> propertyValue) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        if(propertyValue==null) return beanDefinitionBuilder;

        Iterator<String> it = propertyValue.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            beanDefinitionBuilder.addPropertyValue(key, propertyValue.get(key));
        }
        beanDefinitionBuilder.getRawBeanDefinition().setScope(SCOPE_SINGLETON);
        beanDefinitionBuilder.getRawBeanDefinition().setLazyInit(false);
        beanDefinitionBuilder.getRawBeanDefinition().setAutowireCandidate(true);
        return beanDefinitionBuilder;
    }

    public static void registerBean(Class clazz, String beanName, final Map<String, Object> propertyValue) {
        try {
            DefaultListableBeanFactory defaultListableBeanFactory =
                    (DefaultListableBeanFactory) ((ConfigurableApplicationContext)CoApplicationContext.getApplicationContext()).getBeanFactory();
            //defaultListableBeanFactory.containsBeanDefinition()
            BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(clazz, propertyValue);
            defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
            logger.info("registerBean success!!!" + beanName);
        } catch (Exception e) {
            logger.error("Register Error, BeanName: " + beanName, e);
        }
    }

    public static void registerBean(String beanName, BeanDefinitionBuilder beanDefinitionBuilder) {
        DefaultListableBeanFactory defaultListableBeanFactory =
                (DefaultListableBeanFactory) ((ConfigurableApplicationContext)CoApplicationContext.getApplicationContext()).getBeanFactory();
        //defaultListableBeanFactory.containsBeanDefinition()
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
    }

    public static void destoryBean(String beanName) {
        DefaultListableBeanFactory defaultListableBeanFactory =
                (DefaultListableBeanFactory) ((ConfigurableApplicationContext)CoApplicationContext.getApplicationContext()).getBeanFactory();
        //defaultListableBeanFactory.containsBeanDefinition()
        defaultListableBeanFactory.destroyScopedBean(beanName);
    }



}
