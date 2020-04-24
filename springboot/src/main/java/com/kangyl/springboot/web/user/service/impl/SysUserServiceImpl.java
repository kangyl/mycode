package com.kangyl.springboot.web.user.service.impl;

import com.kangyl.springboot.web.user.bean.SysUser;
import com.kangyl.springboot.web.user.bean.query.SysUserQueryParam;
import com.kangyl.springboot.web.user.dao.SysUserDao;
import com.kangyl.springboot.web.user.service.SysTestService;
import com.kangyl.springboot.web.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private SysUserDao sysUserDao;

    @Autowired
    private SysTestService sysTestService;

    @SuppressWarnings("all")
    @Autowired
    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public void addUser(SysUser user) {
        try{
            user.setCreateTime(new Date());
            sysUserDao.insertUser(user);
            sysTestService.testTrans();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateUser(SysUser user) {
        sysUserDao.updateUser(user);
    }

    @Override
    public List<SysUser> findUsers(SysUserQueryParam queryParam) {
        return sysUserDao.findAll(queryParam);
    }
}
