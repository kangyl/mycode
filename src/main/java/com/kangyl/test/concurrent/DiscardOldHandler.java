package com.kangyl.test.concurrent;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月19日
 */
public class DiscardOldHandler implements RejectHandler {

    @Override
    public void reject(MyThreadPoolExecutor executor, Runnable runnable) {

    }
}
