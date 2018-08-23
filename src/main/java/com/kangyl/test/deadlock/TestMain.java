/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.deadlock;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/14
 */
public class TestMain {
    public static void main(String[] args) {
        final LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock(1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.left();
            }
        });

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.right();
            }
        });
        thread1.start();

        leftRightDeadLock.startTest();
    }
}
