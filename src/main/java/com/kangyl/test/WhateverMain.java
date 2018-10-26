package com.kangyl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月17日
 */
public class WhateverMain extends Thread{

    private boolean visible;

    @Override
    public void run(){
        int i = 0;
        while(!visible){
            i++;
        }
        System.out.println(i);
    }

    public void stopIt() {
        visible = true;
    }

    public boolean getStop() {
        return visible;
    }

    public static void main(String[] args) throws Exception{
// /        WhateverMain whateverMain = new WhateverMain();
//        whateverMain.start();
//
//        Thread.sleep(1000);
//        whateverMain.stopIt();
////        Thread.sleep(2000);
//        System.out.println("finish main");
//        System.out.println(whateverMain.getStop());

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                try{
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//            }
//        });
//        thread.start();
//
//        thread.interrupt();
        List<String> s = new ArrayList<>();
        s.wait();
    }
}
