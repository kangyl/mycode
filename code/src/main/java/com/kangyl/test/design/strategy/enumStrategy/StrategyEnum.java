/**
 * Copyright
 */
package com.kangyl.test.design.strategy.enumStrategy;

/**
 * 策略枚举
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/10
 */
public enum StrategyEnum {

    ADD("+"){
        @Override
        public int exec(int a, int b) {
            return a+b;
        }
    },
    SUB("-"){
        @Override
        public int exec(int a, int b) {
            return a-b;
        }
    };

    private String type;


    StrategyEnum(String type) {
        this.type = type;
    }

    public abstract int exec(int a, int b);
}
