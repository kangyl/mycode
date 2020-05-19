package com.kangyl.test.remoteproxy;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/19
 */
public class TestRemoteProxy {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        MyBeanFactoyBeanPostProcessor myBeanFactoyBeanPostProcessor = new MyBeanFactoyBeanPostProcessor();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(MyBeanFactoyBeanPostProcessor.class);
        annotationConfigApplicationContext.registerBeanDefinition(MyBeanFactoyBeanPostProcessor.class.getName(), beanDefinitionBuilder.getBeanDefinition());
        annotationConfigApplicationContext.refresh();

        TestRemoteService testRemoteService = annotationConfigApplicationContext.getBean(TestRemoteService.class);
        List<String> strings = testRemoteService.queryDatas();
        System.out.println(strings.get(0));
//        List list = bean.queryDatas();
//        System.out.println(list);
        annotationConfigApplicationContext.close();
    }
}
