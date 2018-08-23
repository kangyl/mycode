/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.reference;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/26
 */
public class ReferenceTest {

    public static final int LOOP_TIME = 1024 * 100;

    public static void drawMemeory(){
        String[] datas = new String[LOOP_TIME];
        for(int i=0;i<LOOP_TIME;i++) {
            for(int j='a';j<'z';j++) {
                datas[i] += j;
            }
        }
    }
}
