/**
 * Copyright
 */
package com.kangyl.test.design.factoryMethod;

/**
 *
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class CarFactoryImpl implements CarFactory {

    @Override
    public Car createCar(Class clazz) {
         try {
             Car car = (Car)Class.forName(clazz.getName()).newInstance();
             return car;
        } catch (Exception e){
             e.printStackTrace();
             throw new RuntimeException("the class " + clazz.getName() + " is wrong class");
         }
    }
}
