/**
 * Copyright
 */
package com.kangyl.test.design.factoryMethod;

/**
 * 工厂方法模式的定义：定义一个用于创建对象的接口，让子类决定实例化哪个类。工厂方法使一个类的实例化延迟到其子类
 * 优点：良好的封装性，代码结构清晰，降低模块的耦合，只需知道简单的信息即可构建一个类，可以屏蔽类复杂的构造过程
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public interface CarFactory {

    Car createCar(Class clazz);
}
