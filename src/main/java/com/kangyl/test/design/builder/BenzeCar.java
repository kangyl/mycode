package com.kangyl.test.design.builder;

import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年12月05日
 */
public class BenzeCar implements Car {

    private List<String> parts;

    @Override
    public void parts(List<String> parts) {
        this.parts = parts;
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder(" the car has part");
        for(String part : parts) {
            stringBuilder.append(part).append(",");
        }
        System.out.println(stringBuilder);
    }
}
