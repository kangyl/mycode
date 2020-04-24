package com.kangyl.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/2/25
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboServerLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DubboServerLauncher.class, args);
    }
}
