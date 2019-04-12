/**
 * Copyright
 */
package com.kangyl.test.design.media;

import java.util.Random;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/6
 */
public class Saler {
    private AbstractMedia media;

    public Saler(AbstractMedia media) {
        this.media = media;
    }

    public void saleComp(int num) {
        media.sell(num);
        System.out.println("卖出了" + num + "台电脑");
    }

    public int getSaleStatus() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public void cutPriseSell() {
        System.out.println("减价销售");
    }
}
