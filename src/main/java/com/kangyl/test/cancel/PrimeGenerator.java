/**
 * Copyright  2018
 */
package com.kangyl.test.cancel;

import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/4/11
 */
public class PrimeGenerator implements Runnable {

    private  volatile boolean cancel;

    private final List<BigInteger> primes = new ArrayList<>();

    @Override

    public void run() {
        BigInteger bigInteger = BigInteger.ONE;
        while (!cancel){
            bigInteger = bigInteger.nextProbablePrime();
            synchronized (this) {
                primes.add(bigInteger);
            }
        }
    }

    public void cancel(){
        cancel = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }
}
