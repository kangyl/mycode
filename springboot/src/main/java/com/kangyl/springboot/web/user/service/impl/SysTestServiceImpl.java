package com.kangyl.springboot.web.user.service.impl;

import com.kangyl.springboot.web.user.bean.SysTest;
import com.kangyl.springboot.web.user.dao.SysTestDao;
import com.kangyl.springboot.web.user.service.SysTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/1/6
 */
@Service
@Lazy
public class SysTestServiceImpl implements SysTestService {

    @Autowired
    @SuppressWarnings("all")
    private SysTestDao sysTestDao;

    @Override
    public void addTest() {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void testTrans() {
        SysTest sysTest = new SysTest();
        sysTest.setUserName("fgd");
        sysTestDao.insert(sysTest);

//        sysTestDao.insert(new SysTest());
    }
}
