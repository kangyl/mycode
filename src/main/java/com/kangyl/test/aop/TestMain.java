package com.kangyl.test.aop;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.UUID;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class TestMain {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setSerializationId(UUID.randomUUID().toString());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/applicationContext.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setBeanFactory(beanFactory);
        Object object = proxyFactoryBean.getObject();

    }

    private static void registryAdviceAdapter() {
        DefaultAdvisorAdapterRegistry.instance.registerAdapter(new MethodBeforeAdviceAdapter());
    }
}
