/**
 * Copyright
 */
package com.kangyl.test.design.abstractFactory;

/**
 *抽象工厂模式：抽象工厂是围绕一个超级工厂创建其他工厂，该超级工厂又称为其他工厂的工厂。
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/4
 */
public interface AbstractVehicleFactory {

    AbstractVehicleFrame createVehicleFrame();

    AbstractWheel createWheel();
}
