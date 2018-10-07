/**
 * Copyright
 */
package com.kangyl.test.util;

import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/4
 */
public class DefaultClassScanner implements ClassScanner {

    @Override
    public List<Class<?>> getClassListBySuper(String pkg, final Class<?> superClass) {
        Assert.notNull(pkg, "包名不能为空");
        Assert.notNull(superClass, "父类不能为空");

        return new ClassSearchTemplate(pkg) {
            @Override
            protected boolean checkAccess(Class clazz) {
                return superClass.isAssignableFrom(clazz) && !superClass.equals(clazz);
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassList(final String pkg) {
        Assert.notNull(pkg, "包名不能为空");
        return new ClassSearchTemplate(pkg) {
            @Override
            protected boolean checkAccess(Class clazz) {
                return true;
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassListByAnnotation(String pkg, final Class<? extends Annotation> annotationClass) {
        Assert.notNull(pkg, "包名不能为空");
        Assert.notNull(annotationClass, "注解不能为空");

        return new ClassSearchTemplate(pkg) {
            @Override
            protected boolean checkAccess(Class clazz) {
                return clazz.getAnnotation(annotationClass)!=null;
            }
        }.getClassList();
    }

}
