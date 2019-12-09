package com.kangyl.test.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * heap oom test
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/9
 */
public class HeapOOMTest {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        while (true) {
            byte[] res = new byte[111111];
            objects.add(res);
        }
    }
}
