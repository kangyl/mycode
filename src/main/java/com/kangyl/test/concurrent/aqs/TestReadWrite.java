package com.kangyl.test.concurrent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月16日
 */
public class TestReadWrite {


    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    private String value;

    //导致死锁
    public void writeAndRead() {
        readLock.lock();
        try{
             value = "dssd";
            writeLock.lock();
            System.out.println(value);

        }finally {
            readLock.unlock();
        }

        writeLock.unlock();
    }

    public static void main(String[] args) {
        TestReadWrite testReadWrite = new TestReadWrite();
        testReadWrite.writeAndRead();
    }
}
