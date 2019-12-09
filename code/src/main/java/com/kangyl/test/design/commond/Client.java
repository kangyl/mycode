/**
 * Copyright
 */
package com.kangyl.test.design.commond;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Command command = new ConCommand();
        invoker.setCommond(command);

        invoker.action();
    }
}
