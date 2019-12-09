/**
 * Copyright
 */
package com.kangyl.test.design.media;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/6
 */
public class Client {

    public static void main(String[] args) {
        AbstractMedia media = new Media();
        Stock stock = new Stock(media);
        Purchase purchase = new Purchase(media);
        Saler saler = new Saler(media);
        stock.addStock(2);
        purchase.buyComputer(2);
        saler.saleComp(5);

        stock.cleraStock();
    }
}
