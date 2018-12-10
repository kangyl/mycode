/**
 * Copyright
 */
package com.kangyl.test.design.strategy.common;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/10
 */
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int  action(int a,int b) {
        return this.strategy.exec(a, b);
    }
}
