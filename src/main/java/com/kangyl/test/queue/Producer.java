package com.kangyl.test.queue;


/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/14
 */
public class Producer {
    private IResource resource;

    public Producer(IResource resource) {
        this.resource = resource;
    }

    public void produce(){
        while (true){
            resource.put();
        }
    }
}
