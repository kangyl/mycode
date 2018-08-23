/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.aio;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
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
