package com.kangyl.test.concurrent;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月19日
 */
public class MyThreadPoolExecutor extends MyAbstractExecutorService {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    private static final int CAPS_BITS = Integer.SIZE - 3;
    private static final int MAX_CAPS_ = (1 << CAPS_BITS) - 1;
    private static final int RUNNING = -1 << CAPS_BITS;
    private static final int SHUTDOWN = 0 << CAPS_BITS;
    private static final int STOP = 1 << CAPS_BITS;
    private static final int TIYDING = 2 << CAPS_BITS;
    private static final int TERMINATED = 3 << CAPS_BITS;
    private ReentrantLock mainLock = new ReentrantLock();
    private Condition terminatedConditon = mainLock.newCondition();

    private volatile int coreSize;
    private volatile int maxLargeSize;
    private volatile long keepAliveTime;
    private static final RejectHandler defaultHandler = new AbortRejectHandler();
    private ThreadFactory threadFactory;
    private BlockingQueue queue;
    private RejectHandler rejectHandler;
    private HashSet<Worker> workers = new HashSet<>();
    private BlockingQueue<Runnable> workQueue;

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time, TimeUnit timeUnit) {
        this(coreSize, maxLargeSize, time, timeUnit, new DefaultThreadFactory(), new LinkedBlockingQueue(Integer.MAX_VALUE), defaultHandler);
    }

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time, TimeUnit timeUnit, ThreadFactory threadFactory, BlockingQueue queue, RejectHandler rejectHandler) {
        this.coreSize = coreSize;
        this.maxLargeSize = maxLargeSize;
        this.keepAliveTime = timeUnit.toNanos(time);
        this.threadFactory = threadFactory;
        this.queue = queue;
        this.rejectHandler = rejectHandler;
        workQueue = new LinkedBlockingQueue<>(CAPS_BITS);
    }

    private static int ctlOf(int runState, int workCount) {
        return runState | workCount;
    }

    private static int runStateOf(int c) {
        return c & ~CAPS_BITS;
    }

    private static int workCountOf(int c) {
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
        if(command == null) {
            throw new NullPointerException();
        }

        int state = ctl.get();
        int workCount = workCountOf(state);
        if(workCount < coreSize) {
            if(addWorker(command, true)) {
                return;
            }
            state = ctl.get();
        }
        if(isRunning(state) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if(!isRunning(recheck) && remove(command)) {
                rejectHandler.reject(this, command);
            } else if(workCountOf(recheck) == 0) {
                addWorker(null, false);
            }
        } else if(!addWorker(command, false)) {
            rejectHandler.reject(this, command);
        }
    }

    private boolean remove(Runnable command) {
        boolean result = workQueue.remove(command);
        tryTerminated();
        return result;
    }

    private void tryTerminated() {
        for(; ; ) {
            int state = ctl.get();
            if(isRunning(state) || state >= TIYDING || (runStateOf(state) == SHUTDOWN && !workQueue.isEmpty())) {
                return;
            }
            mainLock.lock();
            try {
                if(ctl.compareAndSet(state, ctlOf(TIYDING, 0))) {
                    try {
                        terminated();
                    } finally {
                        ctl.set(ctlOf(TERMINATED, 0));
                        terminatedConditon.signalAll();
                    }
                    return;
                }
            } finally {
                mainLock.unlock();
            }
        }
    }

    protected void terminated() {

    }

    private boolean isRunning(int state) {
        return RUNNING == runStateOf(state);
    }


    private boolean addWorker(Runnable runnable, boolean core) {
        retry:
        for(; ; ) {
            int state = ctl.get();
            int rs = runStateOf(state);
            if(rs >= SHUTDOWN && !(rs == SHUTDOWN && runnable == null && !workQueue.isEmpty())) {
                return false;
            }

            for(;;){
                int ws = workCountOf(state);
                if(ws>MAX_CAPS_ || ws>(core?coreSize:maxLargeSize)){
                    return false;
                }

                if(ctl.compareAndSet(state, state + 1)) {
                    break retry;
                }

                int recheck = ctl.get();
                if(recheck != state) {
                    continue retry;
                }
            }
        }

        boolean workStart = false;
        boolean workAdd = false;
        Worker worker = null;
        try{
            ReentrantLock mainLock = this.mainLock;
            worker = new Worker(runnable);
            Thread thread = worker.thread;
            mainLock.lock();
            try{
                int recheck = ctl.get();
                int rs = runStateOf(recheck);

                if(isRunning(recheck) ||( rs==SHUTDOWN&& runnable==null)){
                    if(thread.isAlive()) {
                        throw new IllegalThreadStateException();
                    }
                    workers.add(worker);
                    workAdd = true;
                }
            }finally {
                mainLock.unlock();
            }
            if(workAdd){
                thread.start();
                workStart = true;
            }
        }finally {
            if(!workStart){
                workAddFailed(worker);
            }
        }
        return workStart;
    }

    private void workAddFailed(Worker worker) {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try{
            workers.remove(worker);
            decreaseWorkCount();
            tryTerminated();
        }finally {
            mainLock.unlock();
        }
    }

    private void decreaseWorkCount() {
        int state = ctl.get();
        for(;;){
            if(ctl.compareAndSet(state, state - 1)) {
                break;
            }
        }
    }

    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {

        private Thread thread;
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.thread = threadFactory.newThread(runnable);
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runWorker(this);
        }

        public void lock() {
            acquire(1);
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        public void unlock() {
            release(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()!=0;
        }
    }

    private void runWorker(Worker worker) {
        if(worker == null) {
            throw new NullPointerException();
        }
        Runnable task = worker.runnable;
        worker.runnable = null;
        worker.unlock();
        while(task != null || getTask() != null) {
            worker.lock();

        }
    }

    private Runnable getTask() {
        return getTask();
    }
}
