/**
 * Copyright
 */
package com.kangyl.test.design.observer;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/11
 */
public class Subject extends Obserable {

    public void eatBreatFirst(String msg) {
        System.out.println("我正在吃早餐：" + msg);
        super.notifyObserver("李某正在吃早餐：" + msg);
    }

    public void addLauch(String msg) {
        System.out.println("我正在吃午餐:" + msg);
        super.notifyObserver("李某正在吃午餐：" + msg);
    }
}
