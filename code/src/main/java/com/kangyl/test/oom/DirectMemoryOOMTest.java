package com.kangyl.test.oom;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=20m -XX:+DisableExplicitGC
 * DisableExplicitGC禁止GC
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/9
 */
public class DirectMemoryOOMTest {
    public static void main(String[] args) {

        while (true) {
            ByteBuffer.allocateDirect(10000*1024);
        }
    }
}
