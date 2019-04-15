package com.kangyl.test.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class ProxyFactoryBean implements FactoryBean<Object>,BeanFactoryAware {

    private BeanFactory beanFactory;
    private List<String> interceptorNames = new ArrayList<>();
    private Class clazz;
    private List<Advisor> advisors = new ArrayList<>();


    @Override
    public Object getObject() {
        initAdvisorChain();
        if(isSingleton()) {

        }else{

        }
        return null;
    }

    private Object getSingleton() {
        Object bean = beanFactory.getBean(clazz);
        return bean;

    }

    public void setInterceptorNames(List<String> interceptorNames) {
        this.interceptorNames = interceptorNames;
    }

    private void initAdvisorChain() {
        for(String interceptorName : interceptorNames) {
            Advisor bean = (Advisor)beanFactory.getBean(interceptorName);
            this.advisors.add(bean);
        }
    }

    public void targetClass(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
