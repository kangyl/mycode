/**
 * Copyright
 */
package com.kangyl.test.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/8
 */
public class Foo {

    public static void main(String[] args) {
        GenericTest<Double> genericTest = new GenericTest<Double>() {
            @Override
            public Double getValue() {
                return 1d;
            }

            @Override
            public int compare(Double value) {
                return 0;
            }
        };

    }


}
