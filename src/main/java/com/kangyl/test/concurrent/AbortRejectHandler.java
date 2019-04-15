package com.kangyl.test.concurrent;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月19日
 */
public class AbortRejectHandler implements RejectHandler {

    @Override
    public void reject(MyThreadPoolExecutor executor, Runnable runnable) {
        throw new RuntimeException("线程池超过最大容量");
    }
}
