/**
 * Copyright
 */
package com.kangyl.test.design.single;

/**
 * 线程安全单例模式(懒加载模式)
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/4
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
