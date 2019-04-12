/**
 * Copyright
 */
package com.kangyl.test.design.observer;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/11
 */
public class Client {

    public static void main(String[] args) {


        Subject subject = new Subject();
        ObserverOne one = new ObserverOne();
        ObserverTwo two = new ObserverTwo();
        subject.addObserver(one);
        subject.addObserver(two);
        subject.addLauch("三明治");
        subject.eatBreatFirst("鸡蛋 豆浆");

    }
}
