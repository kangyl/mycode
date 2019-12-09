/**
 * Copyright  2018
 */
package com.kangyl.test.controller.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/3/10
 */
@Component
public class BeanInitOrderTest implements BeanNameAware,BeanClassLoaderAware,BeanFactoryAware {

    private static Logger logger = LoggerFactory.getLogger(BeanInitOrderTest.class);

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.error("BeanClassLoaderAware execute,classLoader is {}", classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.error("BeanFactoryAware execute,beanFactory is {}", beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        logger.error("BeanNameAware execute,name is {}", name);

    }
}
