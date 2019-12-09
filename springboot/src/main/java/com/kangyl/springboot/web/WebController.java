package com.kangyl.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/6
 */
@RestController
public class WebController {

    @RequestMapping("/abc")
    public void test(HttpServletRequest request) {
        System.out.println("abc");
    }
}
