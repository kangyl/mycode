package com.kangyl.test.fullgc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/4/24
 */
public class FullGcBean implements Runnable {

    private static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

    public void init() {
        Map<String, String> param = new HashMap<>();
        threadLocal.set(param);
    }

    public void start(String key, String value) {
        Map<String, String> stringStringMap = threadLocal.get();
        stringStringMap.put(key, value);
    }

    @Override
    public void run() {
        init();
        Random random = new Random();

        while (true) {
            int i = random.nextInt();
            String s = UUID.randomUUID().toString() + i;
            start(s, s);
        }
    }
}
