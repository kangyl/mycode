package com.kangyl.test.deadlock;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/3/29
 */
public class TestIntCache implements Runnable {

    private int a;
    private int b;

    public TestIntCache(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        int c;
        synchronized (Integer.valueOf(a)) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.valueOf(b)) {
                c = a + b;
            }
        }
        System.out.println(c);
    }


    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            new Thread(new TestIntCache(1, 2)).start();
            new Thread(new TestIntCache(2, 1)).start();
        }
    }

}
