package com.kangyl.test.concurrent;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月19日
 */
public class MyThreadPoolExecutor extends MyAbstractExecutorService {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING,0));

    private static final int CAPS_BITS = Integer.SIZE - 3;
    private static final int MAX_CAPS_ = (1 << CAPS_BITS) - 1;
    private static final int RUNNING = -1 << CAPS_BITS;
    private static final int SHUTDOWN = 0 << CAPS_BITS;
    private static final int STOP = 1 << CAPS_BITS;
    private static final int TIYDING = 2 << CAPS_BITS;
    private static final int TERMINATED = 3 << CAPS_BITS;

    private volatile int coreSize;
    private volatile int maxLargeSize;
    private volatile long keepAliveTime;
    private static final RejectHandler defaultHandler = new AbortRejectHandler();
    private ThreadFactory threadFactory;
    private BlockingQueue queue;
    private RejectHandler rejectHandler;
    private HashSet<Worker> workers = new HashSet<>();

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time,TimeUnit timeUnit) {
        this(coreSize, maxLargeSize, time,timeUnit, new DefaultThreadFactory(), new LinkedBlockingQueue(Integer.MAX_VALUE), defaultHandler);
    }

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time,TimeUnit timeUnit, ThreadFactory threadFactory, BlockingQueue queue, RejectHandler rejectHandler) {
        this.coreSize = coreSize;
        this.maxLargeSize = maxLargeSize;
        this.keepAliveTime = timeUnit.toNanos(time);
        this.threadFactory = threadFactory;
        this.queue = queue;
        this.rejectHandler = rejectHandler;
    }

    private static int ctlOf(int runState, int workCount) {
        return runState | workCount;
    }

    private static int runStateOf(int c){
        return c & ~CAPS_BITS;
    }

    private static int workCountOf(int c){
        return c & CAPS_BITS;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        int state = ctl.get();
        int workCount = workCountOf(state);
        if (workCount < coreSize) {
            if(addWorker(command,true)){
                return;
            }
        } else if (workCount >= coreSize && workCount < maxLargeSize) {
            if (addWorker(command, false)) {
                return;
            }
        }

        rejectHandler.reject(this, command);

    }


    private boolean addWorker(Runnable runnable,boolean core) {


        return false;
    }
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable{

        private Thread thread;
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.thread = threadFactory.newThread(runnable);
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runForWork(this);
        }
    }

    private void runForWork(Worker worker) {

    }
}
