package com.kangyl.test.remoteproxy;

import java.lang.annotation.*;

/**
 * 远程服务代理类
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/19
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RemoteService {

    /**
     * 远程服务ID
     * @return
     */
    String value();
}
