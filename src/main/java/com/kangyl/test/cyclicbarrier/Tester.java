/**
 * Copyright  2018
 */
package com.kangyl.test.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/4/8
 */
public class Tester {

    private final CyclicBarrier cyclicBarrier;
    private final Worker[] workers;

    public Tester(int num,Runnable runnable) {
        this.cyclicBarrier = new CyclicBarrier(num,runnable);
        workers = new Worker[num];
        for (int i = 0; i < num; i++) {
            workers[i] = new Worker("玩家" + i);
        }
    }

    public void start() {
        for (Worker worker : workers) {
            new Thread(worker).start();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("所有玩家准备就绪，GM进场");
            }
        };
        Tester tester = new Tester(5,runnable);
        tester.start();
    }

    private  class Worker implements Runnable {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name+"已经进入游戏，正在等待中...");
            try {
                cyclicBarrier.await();
                System.out.println(name+"进入游戏");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}

