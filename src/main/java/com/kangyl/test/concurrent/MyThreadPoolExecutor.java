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
 * @author kangyl (460720197@qq.com)
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
    private ReentrantLock mainLock = new ReentrantLock();
    private Condition terminatedConditon = mainLock.newCondition();

    private volatile int coreSize;
    private volatile int maxLargeSize;
    private volatile long keepAliveTime;
    private static final RejectHandler defaultHandler = new AbortRejectHandler();
    private ThreadFactory threadFactory;
    private BlockingQueue<Runnable> workQueue;
    private RejectHandler rejectHandler;
    private HashSet<Worker> workers = new HashSet<Worker>();
    private boolean corePoolTimeOut;

    private volatile long totalFinishTask;

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time, TimeUnit timeUnit) {
        this(coreSize, maxLargeSize, time, timeUnit, new DefaultThreadFactory(), new LinkedBlockingQueue(Integer.MAX_VALUE), defaultHandler);
    }

    public MyThreadPoolExecutor(int coreSize, int maxLargeSize, int time, TimeUnit timeUnit, ThreadFactory threadFactory, BlockingQueue queue, RejectHandler rejectHandler) {
        this.coreSize = coreSize;
        this.maxLargeSize = maxLargeSize;
        this.keepAliveTime = timeUnit.toNanos(time);
        this.threadFactory = threadFactory;
        this.workQueue = queue;
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
        private Runnable firstTask;
        volatile long completedTasks;

        public Worker(Runnable firstTask) {
            this.thread = threadFactory.newThread(this);
            this.firstTask = firstTask;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        public void lock() {
             acquire(1);
        }

        public boolean trylock() {
            return tryAcquire(1);
        }

        public void unlock() {
            release(1);
        }

        public boolean isLock() {
            return isHeldExclusively();
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        public void run() {
            runForWork(this);
        }
    }


    private void runForWork(Worker worker) {
        Runnable firstTask = worker.firstTask;
        worker.firstTask = null;
        boolean interrupt = true;
        worker.unlock();
        try{
            while (firstTask != null || (firstTask = getTask()) != null) {
                worker.lock();
                clearInterruptForTaskRun();

                try{
                    Throwable throwable = null;
                    beforeExecute(worker.thread,firstTask);
                    try{
                        firstTask.run();
                    }catch (RuntimeException e){
                        throwable = e;
                        throw e;
                    }catch (Error e){
                        throwable = e;
                        throw e;
                    }catch (Throwable e){
                        throwable = e;
                        throw new Error(e);
                    }
                    finally {
                        afterExecute(worker.thread, throwable);
                    }
                }finally {
                    firstTask = null;
                    worker.completedTasks++;
                    worker.unlock();
                }
            }
            interrupt = false;
        }finally {
            processExistWork(worker, interrupt);
        }


    }

    private void processExistWork(Worker worker, boolean interrupt) {
        if (interrupt) {
            decreaseWorkCount();
        }
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try{
            this.totalFinishTask += worker.completedTasks;
            workQueue.remove(worker);
        }finally {
            mainLock.unlock();
        }

        tryTerminated();

        int c = ctl.get();
        if (isRunning(c)) {
            if(!interrupt){
                int min = corePoolTimeOut ? 0 : coreSize;

                if (min==0 && !workQueue.isEmpty()) {
                    min = 1;
                }
                if (workCountOf(c) >= min) {
                    return;
                }
            }
            addWorker(null, false);
        }
    }

    protected void beforeExecute(Thread thread, Runnable runnable) {

    }

    protected void afterExecute(Thread thread,Throwable e){

    }

    private void clearInterruptForTaskRun() {
        if(ctl.get()<STOP
                && Thread.interrupted()
                &&ctl.get()>=STOP){
            Thread.interrupted();
        }
    }

    /**
     * 获取下一个任务
     * @return
     */
    private Runnable getTask() {
        boolean timeout = false;

        retry:
        for(;;){
            int c = ctl.get();
            int runState = runStateOf(c);
            if (c >= SHUTDOWN || (c >= STOP && workQueue.isEmpty())) {
                decreaseWorkCount();
                return null;
            }

            boolean time;
            for(;;) {
                int workCount = workCountOf(c);
                time = corePoolTimeOut || workCount > coreSize;

                //如果连接超时并且又有时间限制，则会跳过此步骤执行到 return null
                if (workCount < maxLargeSize && !(timeout && time)) {
                    break;
                }
                if(ctl.compareAndSet(c,c-1)){
                    return null;
                }
                int newState = ctl.get();
                if (runStateOf(newState) != runState) {
                    continue retry;
                }
            }

            try {
                Runnable task = time ? workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) : workQueue.take();
                if (task != null) {
                    return task;
                }
                timeout = true;
            } catch (InterruptedException e) {
                timeout = false;
            }

        }

    }
}
