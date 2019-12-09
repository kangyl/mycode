/**
 * Copyright
 */
package com.kangyl.test.design.media;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/6
 */
public abstract class AbstractMedia {

    protected Purchase purchase;
    protected Saler saler;
    protected Stock stock;

    public AbstractMedia() {
        this.purchase = new Purchase(this);
        this.saler = new Saler(this);
        this.stock = new Stock(this);
    }

    abstract void purchaseComp(int num);

    abstract int getSellStatus();

    abstract void sell(int num);

    abstract void buy(int num);

    abstract void cutSell();

    abstract void clearStock();

    abstract void rejectBuy();

    abstract void rejectSell();

}
