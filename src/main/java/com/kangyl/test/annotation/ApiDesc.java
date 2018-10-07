package com.kangyl.test.annotation;

import java.lang.annotation.*;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/4
 */
@Target(ElementType.TYPE)
@Inherited
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ApiDesc {

    String id();

    String serviceComId() default "";

}
