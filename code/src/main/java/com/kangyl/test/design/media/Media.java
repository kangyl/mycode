/**
 * Copyright
 */
package com.kangyl.test.design.media;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class Media extends AbstractMedia {

    @Override
    void purchaseComp(int num) {
        stock.addStock(num);
    }

    @Override
    int getSellStatus() {
        return saler.getSaleStatus();
    }

    @Override
    void sell(int num) {
        stock.reduceStock(num);
    }

    @Override
    void buy(int num) {
        stock.addStock(num);
    }

    @Override
    void cutSell() {
        purchase.rejectBuy();
    }

    @Override
    void clearStock() {
        purchase.rejectBuy();
        saler.cutPriseSell();
    }

    @Override
    void rejectBuy() {
        purchase.rejectBuy();
    }

    @Override
    void rejectSell() {
        saler.cutPriseSell();
    }
}
