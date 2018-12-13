/**
 * Copyright
 */
package com.kangyl.test.design.state;

/**
 * 电梯
 *
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/13
 */
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();


}
