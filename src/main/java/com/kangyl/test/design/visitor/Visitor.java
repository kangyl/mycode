/**
 * Copyright
 */
package com.kangyl.test.design.visitor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/12
 */
public class Visitor implements IVisitor {
    @Override
    public void report(CommonEmploee emploee) {
        emploee.dosome();
    }

    @Override
    public void report(ManagerEmp managerEmp) {
        managerEmp.dosome();
    }
}
