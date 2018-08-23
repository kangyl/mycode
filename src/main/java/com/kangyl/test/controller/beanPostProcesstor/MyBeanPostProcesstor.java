/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.controller.beanPostProcesstor;

import com.kangyl.test.controller.bean.MyConponentBean;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/3/10
 */
@Component
public class MyBeanPostProcesstor implements BeanPostProcessor ,InitializingBean{

    private static Logger logger = LoggerFactory.getLogger(MyBeanPostProcesstor.class);
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.error("afterPropertiesSet execute");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MyConponentBean){
//            logger.error("postProcessBeforeInitialization execute");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MyConponentBean){
//            logger.error("postProcessAfterInitialization execute");
        }

        return bean;
    }
}
