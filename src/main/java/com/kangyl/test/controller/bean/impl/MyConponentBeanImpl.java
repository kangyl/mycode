/**
 * Copyright  2018
 */
package com.kangyl.test.controller.bean.impl;

import com.kangyl.test.controller.bean.MyConponentBean;
import org.springframework.stereotype.Service;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/3/10
 */
@Service
public class MyConponentBeanImpl implements MyConponentBean {
    @Override
    public void test() {
        System.out.println("test");
    }
}
