package com.kangyl.test.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (yulin.kang@ucarinc.com)
 * @since 2018年10月19日
 */
public class DefaultThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread();
    }
}
