/**
 * Copyright
 */
package com.kangyl.test.permission;

import java.security.AccessController;
import java.util.PropertyPermission;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/9/11
 */
public class TestPermission {

    public static void main(String[] args) {
//        System.setProperty("java.security.policy", "java.policy");
        System.setSecurityManager(new SecurityManager());
//        String property = System.getProperty("java.vm.name");
//        System.out.println(property);
        PropertyPermission propertyPermission = new PropertyPermission("java.vm.name", "read");
        AccessController.checkPermission(propertyPermission);
        System.out.println("has permission");
    }
}
