package com.kangyl.test.design.bridge;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/28
 */
public class SuperPencil extends Pencil {

    @Override
    protected void draw() {
        System.out.println(" this super pencil ");
        this.color.bepaint();

    }
}
