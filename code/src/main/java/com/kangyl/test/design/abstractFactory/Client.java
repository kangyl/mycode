/**
 * Copyright
 */
package com.kangyl.test.design.abstractFactory;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class Client {
    public static void main(String[] args) {
        AbstractVehicleFactory vehicleFactory = new HondaVehicleFactory();
        AbstractVehicleFrame vehicleFrame = vehicleFactory.createVehicleFrame();
        vehicleFrame.run();

        AbstractWheel wheel = vehicleFactory.createWheel();
        wheel.run();
    }
}
