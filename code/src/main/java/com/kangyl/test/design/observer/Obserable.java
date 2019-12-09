/**
 * Copyright
 */
package com.kangyl.test.design.observer;

import java.util.Vector;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/11
 */
public class Obserable {

    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String msg) {
        for (Observer observer : observers) {
            observer.doSomething(msg);
        }
    }
}
