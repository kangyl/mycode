package com.kangyl.test.annotation;

import java.lang.annotation.*;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/6
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyFiedAnno {

    String value();

    int maxLength() default -1;

    int minLength() default -1;
}
