/**
 * Copyright
 */
package com.kangyl.test.design.commond;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/12/6
 */
public class Invoker {

    private Command commond;
    public void setCommond(Command commond){
        this.commond = commond;
    }

    public void action() {
        before();
        commond.execute();
        after();
    }

    public void before() {
        System.out.println("命令执行前");
    }

    public void after() {
        System.out.println("命令执行后");
    }

}
