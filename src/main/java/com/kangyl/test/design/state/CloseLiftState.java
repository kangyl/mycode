/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public class CloseLiftState extends LiftState {


    @Override
    public void open() {
        super.context.setLiftState(Context.openState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("lift is closed");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stopState);
        super.context.getLiftState().stop();
    }
}
