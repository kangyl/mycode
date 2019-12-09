/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public class Context {
    public static final LiftState openState = new OpenLiftState();
    public static final LiftState closeState = new CloseLiftState();
    public static final LiftState runState = new RunLiftState();
    public static final LiftState stopState = new StopLiftState();

    private LiftState liftState;


    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }

}
