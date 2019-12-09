/**
 * Copyright
 */
package com.kangyl.test.design.observer;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/11
 */
public class ObserverOne implements Observer {

    @Override
    public void doSomething(String msg) {
        System.out.println("我是监听者1，监听到:" + msg);
    }
}
