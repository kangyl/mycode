package com.kangyl.test.concurrent;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月19日
 */
public interface RejectHandler {

    void reject(MyThreadPoolExecutor executor, Runnable runnable);
}
