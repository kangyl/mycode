/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.threadfactory;

import java.util.concurrent.*;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/14
 */
public class TestThreadPoolFactory extends ThreadPoolExecutor {

    public TestThreadPoolFactory(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TestThreadPoolFactory(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TestThreadPoolFactory(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TestThreadPoolFactory(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t,r);
        System.out.println("开始执行线程:"+t.getName()+"前的操作");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r,t);
        System.out.println("线程执行之后方法");
    }


}
