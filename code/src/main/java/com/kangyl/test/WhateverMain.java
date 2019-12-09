package com.kangyl.test;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月17日
 */
public class WhateverMain {



    public static void main(String[] args) throws Exception{
        System.out.println(loop(1));
    }

    private static int loop(int i){
        i++;
        return loop(i);
    }
}
