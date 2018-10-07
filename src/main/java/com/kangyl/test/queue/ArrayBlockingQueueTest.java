/**
 * Copyright
 */
package com.kangyl.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/9/19
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(2);

        blockingQueue.add(1);
        System.out.println("添加1成功");

        blockingQueue.add(2);
        System.out.println("添加2成功");

        try{
            blockingQueue.put(3);
            System.out.println("添加3成功");
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
