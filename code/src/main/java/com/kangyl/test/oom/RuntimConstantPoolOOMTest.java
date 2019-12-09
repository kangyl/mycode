package com.kangyl.test.oom;

/**
 * jdk8及以上都是报这个
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 *
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/9
 */
public class RuntimConstantPoolOOMTest {

    public static void main(String[] args) {
        Long i = 0L;
        while (true) {
            StringBuilder stringBuilder = new StringBuilder("长得帅的所得税但是");
            stringBuilder.append(i++).toString().intern();
        }
    }
}
