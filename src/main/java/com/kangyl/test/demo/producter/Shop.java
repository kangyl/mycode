package com.kangyl.test.demo.producter;

import org.springframework.util.Assert;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月26日
 */
public class Shop {

    private BlockingQueue<String> queue;

    public Shop() {
        this.queue = new LinkedBlockingQueue<>(10);
    }

    public void createFood(int num) {
        Assert.isTrue(num > 0);
        for(int i =0;i<num;i++) {
            queue.offer("food");
        }
    }

    public String getFood() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.createFood(3);


        for(int i=0;i<4;i++) {
            System.out.println(shop.getFood());
        }
    }
}
