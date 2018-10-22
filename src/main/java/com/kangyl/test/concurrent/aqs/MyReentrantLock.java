package com.kangyl.test.concurrent.aqs;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月18日
 */
public class MyReentrantLock implements Serializable, Lock {

    private static final long serialVersionUID = -4215819107342656631L;
    private Sync sync;


    static abstract class Sync extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = -4428010398057505266L;

        abstract void lock();

        final boolean nonfairTryAcquire(int args) {
            int state = getState();
            Thread thread = Thread.currentThread();
            if (state == 0) {
                if (compareAndSetState(0, args)) {
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            } else if (isHeldExclusively()) {
                int newState = state + args;
                if (newState < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(newState);
                return true;
            }
            return false;
        }


        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            int state = getState() - arg;
            boolean free = false;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                free = true;
            }
            setState(state);
            return free;
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final int holdCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        final boolean isLock() {
            return getState() != 0;
        }
    }

    private static class NonfairSync extends Sync {

        private static final long serialVersionUID = -5632487025309382416L;

        @Override
        final void lock() {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return nonfairTryAcquire(arg);
        }
    }

    private static class FairSync extends Sync{

        private static final long serialVersionUID = 4320606719624124618L;

        @Override
        void lock() {
            acquire(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            Thread thread = Thread.currentThread();
            if (state == 0) {
                if(!hasQueuedPredecessors()&&compareAndSetState(0,1)){
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            } else if (thread == getExclusiveOwnerThread()) {
                int newState = state + arg;
                if (newState < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(newState);
                return true;
            }

            return false;
        }
    }

    public MyReentrantLock() {
        sync = new NonfairSync();
    }

    /**
     *
     * @param fair  是否公平锁
     */
    public MyReentrantLock(boolean fair){
        sync = fair ? new FairSync() : new NonfairSync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLock() {
        return sync.isLock();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public boolean isFair(){
        return sync instanceof FairSync;
    }

    public boolean isHeldByCurrent() {
        return sync.isHeldExclusively();
    }


    public Collection<Thread> getQueueThreads() {
        return sync.getQueuedThreads();
    }

    public boolean isQueued(Thread thread) {
        return sync.isQueued(thread);
    }
}
