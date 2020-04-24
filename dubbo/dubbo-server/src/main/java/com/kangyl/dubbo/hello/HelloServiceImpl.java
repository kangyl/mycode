package com.kangyl.dubbo.hello;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/2/25
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello() {
        return "hello dubbo";
    }
}
