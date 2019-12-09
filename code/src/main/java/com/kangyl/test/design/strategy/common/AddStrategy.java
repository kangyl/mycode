/**
 * Copyright
 */
package com.kangyl.test.design.strategy.common;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/10
 */
public class AddStrategy implements IStrategy {

    @Override
    public int exec(int a, int b) {
        return a+b;
    }
}
