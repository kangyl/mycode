package com.kangyl.springboot.web.user.dao;

import com.kangyl.springboot.web.user.bean.SysTest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/1/6
 */
@Mapper
public interface SysTestDao {

    void insert(SysTest sysTest);
}
