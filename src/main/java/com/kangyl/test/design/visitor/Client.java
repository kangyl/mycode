/**
 * Copyright
 */
package com.kangyl.test.design.visitor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/12/12
 */
public class Client {

    public static void main(String[] args) {
        IVisitor visitor = new Visitor();
        Emploee emploee = new CommonEmploee();
        Emploee manage = new ManagerEmp();
        emploee.accept(visitor);
        manage.accept(visitor);


    }
}
