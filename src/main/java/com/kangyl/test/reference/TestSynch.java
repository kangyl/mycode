/**
 * Copyright  2018
 */
package com.kangyl.test.reference;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/1
 */
public class TestSynch {


    private ThreadLocal<String> localMsg = new ThreadLocal<String>();

    public void initMsg(String msg) {
        localMsg.set(msg);
    }

    public String getMsg() {
        return localMsg.get();
    }
}
