package com.kangyl.test.queue.object;

import com.kangyl.test.queue.IResource;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class Resource  implements IResource {

    private Object lock = new Object();
    private int size =10;

    private int num;

    public void get(){
        try{
            synchronized (lock){
                if(num==0){
                    System.out.println("waiting producer..");
                    lock.wait();
                }
                num--;
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void put(){
        try{
            synchronized (lock){
                if(num==size){
                    System.out.println("waiting consumer..");
                    lock.wait();
                }
                num++;
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
