package com.kangyl.test.concurrent;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (yulin.kang@ucarinc.com)
 * @since 2018年10月19日
 */
public interface RejectHandler {

    void reject(MyThreadPoolExecutor executor, Runnable runnable);
}
