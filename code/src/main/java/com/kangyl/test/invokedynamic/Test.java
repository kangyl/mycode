package com.kangyl.test.invokedynamic;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/10/13
 */
public class Test {

    public static void main(String[] args) throws Throwable{
        (new TestInvokeDynamic().new Son()).thinking();


    }
}
