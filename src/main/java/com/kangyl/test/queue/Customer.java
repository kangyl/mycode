package com.kangyl.test.queue;


/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class Customer {
    private IResource resource;

    public Customer(IResource resource) {
        this.resource = resource;
    }

    public void consume(){
        while (true){
            resource.get();
        }
    }
}
