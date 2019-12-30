package com.kangyl.test.design.bridge;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/28
 */
public abstract class Pencil {

    protected Color color;

    protected Pencil setColor(Color color) {
        this.color = color;
        return this;
    }

    protected abstract void draw();
}
