/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.shutdown;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/13
 */
public class TestShutDownHook {

    public static void main(String[] args) {
        System.out.println(1);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("执行关闭狗子1");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("执行关闭狗子2");
                while(true){

                }

            }
        });

        System.out.println("22");
    }
}
