package com.kangyl.test.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月19日
 */
public abstract class MyAbstractExecutorService implements ExecutorService {

    protected <T> FutureTask<T> newFutureTask(Runnable runnable, T result) {
        return new FutureTask(runnable, result);
    }

    protected <T> FutureTask<T> newFutureTask(Callable<T> callable) {
        return new FutureTask(callable);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) {
            throw new NullPointerException();
        }
        FutureTask<T> futureTask = newFutureTask(task);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) {
            throw new NullPointerException();
        }
        FutureTask<T> futureTask = newFutureTask(task, result);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public Future<?> submit(Runnable task) {
        if (task == null) {
            throw new NullPointerException();
        }
        FutureTask futureTask = newFutureTask(task, null);
        execute(futureTask);
        return futureTask;
    }

    private static final class RunnableAdapter<T> implements Callable<T> {

        private Runnable runnable;
        private T result;

        public RunnableAdapter(Runnable runnable, T result) {
            this.runnable = runnable;
            this.result = result;
        }

        @Override
        public T call() throws Exception {
            runnable.run();
            return result;
        }
    }
}
