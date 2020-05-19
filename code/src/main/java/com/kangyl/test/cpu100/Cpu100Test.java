package com.kangyl.test.cpu100;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/4/25
 */
public class Cpu100Test implements Runnable {

    @Override
    public void run() {
        start();
    }

    public void start() {
        int i = 0;
        while (true) {
            i++;
        }
    }
}
