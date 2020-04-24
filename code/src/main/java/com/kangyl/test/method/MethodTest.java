package com.kangyl.test.method;

import java.lang.reflect.Method;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/1/8
 */
public class MethodTest {

    private class InnerClass {
        private String name = "小明";
    }

    public static void main(final String[] arguments) {
        InnerClass innerClass = new MethodTest().new InnerClass();
        System.out.println("name: " + innerClass.name);

        Method[] declaredMethods = innerClass.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
// 【static java.lang.String lang.reflect.MethodTest$InnerClass.access$100(lang.reflect.MethodTest$InnerClass)】 isSynthetic(): true
            System.out.println("【" + declaredMethod + "】" + " isSynthetic(): " + declaredMethod.isSynthetic());
        }
    }
}
