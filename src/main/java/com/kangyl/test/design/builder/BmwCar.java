package com.kangyl.test.design.builder;

import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年12月05日
 */
public class BmwCar implements Car {

    private List<String> parts;

    @Override
    public void parts(List<String> parts) {
        this.parts = parts;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder(" the bmw car has parts ");
        for(String part : parts) {
            sb.append(part).append(",");
        }
        System.out.println(sb);
    }
}
