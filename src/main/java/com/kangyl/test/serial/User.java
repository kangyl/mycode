/**
 * Copyright  2018
 */
package com.kangyl.test.serial;

import java.io.Serializable;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/3/10
 */
public class User implements Serializable{

    private static final long serialVersionUID = -7901880595918928711L;
    private String id;

    private String userName;

    private String userCode;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public User setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("id", id)
                .append("userName", userName)
                .append("userCode", userCode)
                .toString();
    }
}
