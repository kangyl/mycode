package com.kangyl.test.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月30日
 */
@Service
public class UserServiceImpl implements IUserService {

    @Cacheable("getUserName")
    public String getUserName() {
        System.out.println("before get user name");
        return "joson";
    }

    @CacheEvict(value = {"getUserName"})
    public void clearUser() {
        System.out.println("enter clear user");
    }
}
