/**
 * Copyright
 */
package com.kangyl.test.design.factoryMethod;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class Main {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactoryImpl();
        Car car = carFactory.createCar(Toyota.class);
        car.getBrand();
        car.getColor();

        Car honda = carFactory.createCar(Honda.class);
        honda.getBrand();
        honda.getColor();
    }
}
