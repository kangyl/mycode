/**
 * Copyright  2018
 */
package com.kangyl.test.reference;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/1
 */
public class MultiThread {

    public static void main(String[] args) {
        final TestSynch testSynch = new TestSynch();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                testSynch.initMsg(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+testSynch.getMsg());
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                testSynch.initMsg(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+testSynch.getMsg());
            }
        });
        thread2.start();
    }
}
