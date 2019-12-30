package com.kangyl.springboot.web.user.dao;

import com.kangyl.springboot.web.user.bean.SysUser;
import com.kangyl.springboot.web.user.bean.query.SysUserQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
@Mapper
public interface SysUserDao {

    int insertUser(SysUser user);

    int updateUser(SysUser user);

    int deleteUser(SysUser user);

    List<SysUser> findAll(SysUserQueryParam param);
}
