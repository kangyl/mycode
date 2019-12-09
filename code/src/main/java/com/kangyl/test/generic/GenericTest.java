/**
 * Copyright
 */
package com.kangyl.test.generic;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/10/8
 */
public interface GenericTest<T extends Number> {

    T getValue();

    int compare(T value);
}
