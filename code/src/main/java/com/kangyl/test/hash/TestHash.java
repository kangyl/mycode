/**
 * Copyright  2018
 */
package com.kangyl.test.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/12
 */
public class TestHash {

    public static void main(String[] args) {
        Person zs = new Person("1234", "张三");
        Map<Person, String> map = new HashMap<Person, String>();
        map.put(zs, "111");

        Person ls = new Person("1234", "李四");
        String s = map.get(ls);
        System.out.println(s);
    }
}
