package com.kangyl.springboot.web.user.bean.query;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/30
 */
public class SysUserQueryParam {

    private String userName;

    private Integer age;

    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
