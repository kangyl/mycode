/**
 * Copyright
 */
package com.kangyl.test.design.abstractFactory;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class HondaVehicleFactory implements AbstractVehicleFactory {

    @Override
    public AbstractVehicleFrame createVehicleFrame() {
        return new HondaWheelFrame();
    }

    @Override
    public AbstractWheel createWheel() {
        return new HondaWheel();
    }
}
