/**
 * Copyright
 */
package com.kangyl.test.design.factoryMethod;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class Toyota implements Car {

    @Override
    public void getBrand() {
        System.out.println("this brand is toyoya");
    }

    @Override
    public void getColor() {
        System.out.println(" the car color is red");
    }
}
