package com.kangyl.test.design.bridge;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/28
 */
public class RedColor implements Color {

    @Override
    public void bepaint() {
        System.out.println(" color is red");
    }
}
