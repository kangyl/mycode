/**
 * Copyright
 */
package com.kangyl.test.design.single;

/**
 *饿汉形式单例
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/4
 */
public class HungrySingleton {
    private  static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return singleton;
    }

}
