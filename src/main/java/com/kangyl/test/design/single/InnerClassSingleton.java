/**
 * Copyright
 */
package com.kangyl.test.design.single;

/**
 *静态内部类持有
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/4
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){

    }

    public static InnerClassSingleton getInstance() {
        return InnerClass.singleton;
    }

    private static class  InnerClass {
        private static InnerClassSingleton singleton = new InnerClassSingleton();
    }
}
