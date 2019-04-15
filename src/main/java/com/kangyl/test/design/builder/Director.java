package com.kangyl.test.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年12月05日
 */
public class Director {

    public Car getBenchCar(){
        List<String> parts = new ArrayList<String>();
        parts.add("benze");
        parts.add("s350");
        parts.add("四轮驱动");
        CarBuilder carBuilder = new BenzeCarBuilder();
        carBuilder.setPart(parts);
        return carBuilder.buildCar();
    }

    public Car getBmwCar(){
        List<String> parts = new ArrayList<String>();
        parts.add("baoma");
        parts.add("x6");
        parts.add("前轮驱动");
        CarBuilder carBuilder = new BmwCarBuilder();
        carBuilder.setPart(parts);
        return carBuilder.buildCar();
    }

    public static void main(String[] args) {
        Director director = new Director();
        Car benchCar = director.getBenchCar();
        Car bmwCar = director.getBmwCar();
        benchCar.run();
        bmwCar.run();
    }
}
