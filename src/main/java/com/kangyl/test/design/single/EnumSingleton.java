/**
 * Copyright
 */
package com.kangyl.test.design.single;

/**
 *由枚举持有单例，这是最安全的单例模式，可以避免序列化和反序列化的线程安全问
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/4
 */
public enum EnumSingleton {

    single("zhangsan",3,5);

    private String name;

    private int age;

    private int no;

    EnumSingleton(String name, int age, int no) {
        this.name = name;
        this.age = age;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNo() {
        return no;
    }
}
