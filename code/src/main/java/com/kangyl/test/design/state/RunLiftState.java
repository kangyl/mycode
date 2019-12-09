/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public class RunLiftState extends LiftState {



    @Override
    public void open() {
        System.out.println("lift is run can't open");
    }

    @Override
    public void close() {
        System.out.println(" lift is run must be close");
    }

    @Override
    public void run() {
        System.out.println(" lift is running");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stopState);
        super.context.getLiftState().stop();
    }
}
