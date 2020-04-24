package com.kangyl.test.fullgc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/4/24
 */
public class FullGcTestMain {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new FullGcBean());
        }
    }
}
