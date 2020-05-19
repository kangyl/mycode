package com.kangyl.test.cpu100;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/4/25
 */
public class TestCpuMain {

    public static void main(String[] args) {
        Cpu100Test cpu100Test = new Cpu100Test();
        Thread thread = new Thread(cpu100Test);
        thread.setName("t1");
        thread.start();

        Thread thread1 = new Thread(new Cpu100Test());
        thread1.setName("t2");

        thread1.start();
    }
}
