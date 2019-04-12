/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public class OpenLiftState extends LiftState {


    @Override
    public void open() {
        System.out.println(" open the lift");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closeState);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        System.out.println("lift is open can't run");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stopState);
        super.context.getLiftState().stop();
    }
}
