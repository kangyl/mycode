package com.kangyl.test.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/6
 */
@RestController
public class TestController {

    @RequestMapping("/abc")
    public void test(){
        System.out.println("abc");
    }
}
