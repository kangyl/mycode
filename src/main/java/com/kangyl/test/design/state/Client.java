/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        LiftState openState = new OpenLiftState();
        context.setLiftState(openState);
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
