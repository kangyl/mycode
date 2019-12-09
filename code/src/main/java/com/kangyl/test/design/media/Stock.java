/**
 * Copyright
 */
package com.kangyl.test.design.media;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/6
 */
public class Stock {
    private static int STOCK_NUM = 100;

    private AbstractMedia media;

    public Stock(AbstractMedia media) {
        this.media = media;
    }

    public int getStockNum() {
        return STOCK_NUM;
    }

    public void reduceStock(int num) {
        STOCK_NUM -= num;
    }

    public void addStock(int num) {
        STOCK_NUM += num;
    }

    public void cleraStock() {
        System.out.println("清空库存");
        STOCK_NUM = 0;
        media.rejectBuy();
        media.rejectSell();
    }
}
