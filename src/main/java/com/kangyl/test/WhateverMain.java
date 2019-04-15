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
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月17日
 */
public class WhateverMain {



    public static void main(String[] args) throws Exception{
        System.out.println(loop(1));
    }

    private static int loop(int i){
        i++;
        return loop(i);
    }
}
