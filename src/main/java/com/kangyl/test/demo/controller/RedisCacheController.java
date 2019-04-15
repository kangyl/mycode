package com.kangyl.test.demo.controller;

import com.kangyl.test.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月30日
 */
@Controller
@RequestMapping("/redis")
public class RedisCacheController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/userName",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getUserName(){
        try{
            return userService.getUserName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/clear")
    public void clearUserName() {
        userService.clearUser();
    }
}
