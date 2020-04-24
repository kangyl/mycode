package com.kangyl.springboot.web.user.controller;

import com.kangyl.springboot.web.common.CommonResponse;
import com.kangyl.springboot.web.user.bean.SysUser;
import com.kangyl.springboot.web.user.bean.query.SysUserQueryParam;
import com.kangyl.springboot.web.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/add")
    public Object addUser( SysUser user) {
        try{
            sysUserService.addUser(user);
            return CommonResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            return CommonResponse.failure();
        }

    }

    @RequestMapping("/update")
    public Object updateUser(SysUser user) {
        try{
            sysUserService.updateUser(user);
            return CommonResponse.success();
        }catch (Exception e){
            return CommonResponse.failure();
        }
    }

    @RequestMapping("/list")
    public Object listUsers(SysUserQueryParam queryParam) {
        return sysUserService.findUsers(queryParam);
    }
}
