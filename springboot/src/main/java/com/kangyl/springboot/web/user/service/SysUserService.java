package com.kangyl.springboot.web.user.service;

import com.kangyl.springboot.web.user.bean.SysUser;
import com.kangyl.springboot.web.user.bean.query.SysUserQueryParam;

import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
public interface SysUserService {

    void addUser(SysUser user);

    void updateUser(SysUser user);

    List<SysUser> findUsers(SysUserQueryParam queryParam);
}
