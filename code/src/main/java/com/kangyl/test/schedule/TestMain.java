package com.kangyl.test.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/27
 */
public class TestMain {

    public static void main(String[] args) {
        ScheduledExecutorService scheduleService = Executors.newScheduledThreadPool(1, Executors.defaultThreadFactory());

        System.out.println(Long.MAX_VALUE >> 1);
//        final Random random = new Random();
//        scheduleService.scheduleAtFixedRate(() -> {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//            System.out.println("current time:" + simpleDateFormat.format(new Date()));
//            try {
//                int ranNum = random.nextInt(10);
//                if(ranNum<5){
//                    Thread.sleep(3000);
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 5, 2, TimeUnit.SECONDS);
    }
}
