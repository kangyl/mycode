/**
 * Copyright
 */
package com.kangyl.test.design.strategy;

import com.kangyl.test.design.strategy.common.AddStrategy;
import com.kangyl.test.design.strategy.common.Context;
import com.kangyl.test.design.strategy.common.IStrategy;
import com.kangyl.test.design.strategy.common.SubtractStrategy;
import com.kangyl.test.design.strategy.enumStrategy.StrategyEnum;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/10
 */
public class Client {

    public static void main(String[] args) {
        IStrategy add = new AddStrategy();
        Context context = new Context(add);
        System.out.println(context.action(5, 6));

        SubtractStrategy strategy = new SubtractStrategy();
        context = new Context(strategy);
        System.out.println(context.action(5, 6));

        System.out.println(StrategyEnum.ADD.exec(5, 6));
        System.out.println(StrategyEnum.SUB.exec(5,6));

    }
}
