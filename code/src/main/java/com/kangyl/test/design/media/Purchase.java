/**
 * Copyright
 */
package com.kangyl.test.design.media;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class Purchase {

    private AbstractMedia media;
    public Purchase(AbstractMedia media) {
        this.media = media;
    }

    public void buyComputer(int num) {

    }

    public void rejectBuy() {
        System.out.println("拒绝购买电脑");

    }
}
