/**
 * Copyright
 */
package com.kangyl.test.design.commond;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class ConCommand implements Command {
    private Reciver reciver = new ConReciver();
    @Override
    public void execute() {
        reciver.doSomething();
    }
}
