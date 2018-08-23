/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.controller.bean.impl;

import com.kangyl.test.controller.bean.MyConponentBean;
import org.springframework.stereotype.Service;

/**
 *
 *@author : kangyl(kangyl@mysinosoft.com)
 *@date: 2018/3/10
 */
@Service
public class MyConponentBeanImpl implements MyConponentBean {
    @Override
    public void test() {
        System.out.println("test");
    }
}
