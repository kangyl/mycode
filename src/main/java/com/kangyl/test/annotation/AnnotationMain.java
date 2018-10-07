/**
 * Copyright
 */
package com.kangyl.test.annotation;

import com.kangyl.test.util.ClassScanner;
import com.kangyl.test.util.DefaultClassScanner;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/4
 */
public class AnnotationMain {

    public static final String PKG_NAME = "com.kangyl.test.annotation";
    private static ClassScanner classScanner = new DefaultClassScanner();

    public static void main(String[] args) {
//        testFindByAnnotation();
//        testfindBySuper();
        testFindFieldAnnotation();
    }

    private static void testFindFieldAnnotation() {
        List<Class<?>> classList = classScanner.getClassListByAnnotation(PKG_NAME,ApiDesc.class);
        for (Class<?> clazz : classList) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                MyFiedAnno annotation = field.getAnnotation(MyFiedAnno.class);
                if (annotation != null) {
                    String value = annotation.value();
                    int minLength = annotation.minLength();
                    int maxLength = annotation.maxLength();
                    System.out.println(value+","+minLength+","+maxLength);
                }
            }
        }
    }

    private static void testfindBySuper() {
        List<Class<?>> classListBySuper = classScanner.getClassListBySuper(PKG_NAME, TestSuper.class);
        for (Class<?> aClass : classListBySuper) {
            System.out.println(aClass.getName());
        }
    }

    private static void testFindByAnnotation() {
        List<Class<?>> classList = classScanner.getClassListByAnnotation(PKG_NAME,ApiDesc.class);
        for (Class<?> clazz : classList) {
            ApiDesc apiDesc = clazz.getAnnotation(ApiDesc.class);
            if (null == apiDesc) {
                continue;
            }

            String id = apiDesc.id();
            String serviceComId = apiDesc.serviceComId();
            System.out.println("class:"+clazz.getName()+",id:" + id + ",serviceComId:" + serviceComId);
        }
    }
}
