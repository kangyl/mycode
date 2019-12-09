/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/20
 */
public class ClientMain {

    public static void main(String[] args) {
        try {
//            AsyncSocketTest asyncSocketTest = new AsyncSocketTest();
//            asyncSocketTest.start();
            SimpleClient simpleClient = new SimpleClient();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
