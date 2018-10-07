/**
 * Copyright
 */
package com.kangyl.test.util;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/10/4
 */
public interface ClassScanner {

    List<Class<?>> getClassListBySuper(String pkg, Class<?> superClass);

    List<Class<?>> getClassList(String pkg);

    List<Class<?>> getClassListByAnnotation(String pkgName, Class<? extends Annotation> annotationClass);
}
