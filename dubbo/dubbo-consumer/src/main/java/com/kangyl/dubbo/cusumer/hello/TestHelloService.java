package com.kangyl.dubbo.cusumer.hello;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kangyl.dubbo.hello.IHelloService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/2/25
 */
@Component
public class TestHelloService implements InitializingBean {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private IHelloService helloService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(helloService.hello());
    }
}
