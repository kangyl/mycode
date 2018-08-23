/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.future;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/8
 */
public class TestMain {

    public static void main(String[] args) {
        PreLoader preLoader = new PreLoader();
//        preLoader.start();
        PreLoader.ProductInfo productInfo = preLoader.get();
        System.out.print(productInfo.getResult());
    }
}
