package com.kangyl.test.oom;

/**
 * java.lang.StackOverflowError
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/9
 */
public class StackOOMTest {

    public static void main(String[] args) {
        iteraotr();
    }

    private static void iteraotr() {
        iteraotr();
    }
}
