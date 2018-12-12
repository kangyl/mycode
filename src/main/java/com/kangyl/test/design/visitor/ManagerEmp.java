/**
 * Copyright
 */
package com.kangyl.test.design.visitor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/12
 */
public class ManagerEmp implements Emploee {

    @Override
    public void dosome() {
        System.out.println("我是管理者");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.report(this);
    }
}
