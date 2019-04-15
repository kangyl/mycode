package com.kangyl.test.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * <p> Description:原子引用,解决ABA问题
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月17日
 */
public class AbaTest {

    static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<Integer>(5, true);

    public static void main(String[] args)throws InterruptedException {
        final Integer reference = atomicMarkableReference.getReference();
        final boolean marked = atomicMarkableReference.isMarked();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = atomicMarkableReference.compareAndSet(reference, reference + 15, marked, false);
                System.out.println("CAS结果:" + result);
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = atomicMarkableReference.compareAndSet(reference, reference + 10, marked, false);
                System.out.println("CAS结果:" + result);
            }
        });

        thread.start();
        thread.join();
        thread1.start();
        thread1.join();

        System.out.println(atomicMarkableReference.getReference());
    }


}
