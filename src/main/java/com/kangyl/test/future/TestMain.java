/**
 * Copyright  2018
 */
package com.kangyl.test.future;

/**
 * @author : kangyl(460720197@qq.com)
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
