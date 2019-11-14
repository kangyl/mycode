package com.kangyl.test.queue.lock;

import com.kangyl.test.queue.IResource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class Resource implements IResource {

    private static int FULL_SIZE = 20;
    private int num;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void get(){
        lock.lock();
        try{
            while (num==0){
                System.out.println("resource is empty,waiting producer.....");
                condition.await();
            }
            num--;
            condition.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void put(){
        lock.lock();
        try{
            while (num==FULL_SIZE){
                System.out.println("resource is full,waiting customer..");
                condition.await();
            }
            num++;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
