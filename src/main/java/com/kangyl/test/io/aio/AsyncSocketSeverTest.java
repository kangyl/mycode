/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/8/19
 */
public class AsyncSocketSeverTest implements Runnable {

    private AsynchronousChannelGroup asynchronousChannelGroup;
    private AsynchronousServerSocketChannel listenner;
    private AtomicInteger threadCount = new AtomicInteger(0);

    public AsyncSocketSeverTest() throws IOException{
        ExecutorService executor = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
                getThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        listenner = AsynchronousServerSocketChannel.open(asynchronousChannelGroup).bind(new InetSocketAddress(91));
    }

    private ThreadFactory getThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                int i = threadCount.incrementAndGet();
                thread.setName("socketServer" + i);
                return thread;
            }
        };
    }

    @Override
    @SuppressWarnings("all")
    public void run() {
        try{
                AioAcceptHandler aioAcceptHandler = new AioAcceptHandler();
                listenner.accept(listenner, new AioAcceptHandler());
                Thread.sleep(1000000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finished server");
        }


    }
}
