package com.kangyl.test.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (yulin.kang@ucarinc.com)
 * @since 2018年10月17日
 */
public class FieldUpdaterTest {

    private volatile int age;

    public static void main(String[] args) {
        final FieldUpdaterTest test = new FieldUpdaterTest();

        final AtomicIntegerFieldUpdater<FieldUpdaterTest> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FieldUpdaterTest.class, "age");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = fieldUpdater.incrementAndGet(test);
                System.out.println("age is:" + i);
            }
        };

        ExecutorService executorService = new ThreadPoolExecutor(5, 20, 22,
                TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), getDefaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for(int i =0;i<100;i++){
            executorService.submit(runnable);
        }
    }

    private static ThreadFactory getDefaultThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                SecurityManager s = System.getSecurityManager();
                ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
                Thread thread = new Thread(group,r);
                thread.setDaemon(true);
                thread.setPriority(Thread.NORM_PRIORITY);
                return thread;
            }
        };
    }
}
