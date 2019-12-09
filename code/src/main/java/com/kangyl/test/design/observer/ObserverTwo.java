/**
 * Copyright
 */
package com.kangyl.test.design.observer;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/11
 */
public class ObserverTwo implements Observer {

    @Override
    public void doSomething(String msg) {
        System.out.println("我是监听者2，监听到:" + msg);
    }
}
