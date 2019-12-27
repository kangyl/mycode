package com.kangyl.test.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/kyl
 * -XX:+TraceClassLoading 打印类加载信息，解决包冲突
 * 使用jvisualvm分析
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
