package com.kangyl.test.demo.producter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月26日
 */
public class NewShop {

    private static final int MAX_SIZE = 10;
    private List<String> foods = new ArrayList<String>();

    public void createFood() {
        synchronized(foods) {
            if(foods.size() == MAX_SIZE) {
                try {
                    foods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
