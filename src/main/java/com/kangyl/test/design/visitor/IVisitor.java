/**
 * Copyright
 */
package com.kangyl.test.design.visitor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/12
 */
public interface IVisitor {

    void report(CommonEmploee emploee);

    void report(ManagerEmp managerEmp);
}
