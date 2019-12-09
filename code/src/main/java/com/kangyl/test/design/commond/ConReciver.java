/**
 * Copyright
 */
package com.kangyl.test.design.commond;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class ConReciver implements Reciver {

    @Override
    public void doSomething() {
        System.out.println("接到命令，开始执行任务");
    }
}
