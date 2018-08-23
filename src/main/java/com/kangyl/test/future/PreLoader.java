/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/4/8
 */
public class PreLoader {

    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(
            new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < 10000; i++) {
                        sum += i;
                    }
                    ProductInfo productInfo = new ProductInfo();
                    productInfo.setResult(sum);

                    return productInfo;
                }
            });

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo get() {
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public class ProductInfo {

        private int result;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }


    }
}
