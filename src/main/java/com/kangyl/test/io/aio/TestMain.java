/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.aio;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/8/20
 */
public class TestMain {

    public static void main(String[] args) {
        try{
//            AsyncSocketSeverTest severTest = new AsyncSocketSeverTest();
//            Thread thread = new Thread(severTest);
//            thread.start();
            SimpleServer simpleServer = new SimpleServer();
            Thread.sleep(100000);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
