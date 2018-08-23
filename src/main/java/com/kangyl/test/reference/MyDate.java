/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.reference;

import java.util.Date;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/2/26
 */
public class MyDate extends Date {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("obj Date["+this.getTime()+"] is gc");
    }

    @Override
    public String toString() {
        return "Date:" + this.getTime();
    }
}
