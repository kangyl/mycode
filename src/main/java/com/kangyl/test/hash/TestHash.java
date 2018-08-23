/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/3/12
 */
public class TestHash {

    public static void main(String[] args) {
        Person zs = new Person("1234", "张三");
        Map<Person, String> map = new HashMap<>();
        map.put(zs, "111");

        Person ls = new Person("1234", "李四");
        String s = map.get(ls);
        System.out.println(s);
    }
}
