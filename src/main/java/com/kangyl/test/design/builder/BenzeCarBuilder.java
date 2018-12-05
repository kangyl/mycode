package com.kangyl.test.design.builder;

import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年12月05日
 */
public class BenzeCarBuilder implements CarBuilder {

    private List<String> parts;

    @Override
    public void setPart(List<String> parts) {
        this.parts = parts;
    }

    @Override
    public Car buildCar() {
        Car car = new BenzeCar();
        car.parts(this.parts);
        return car;
    }
}
