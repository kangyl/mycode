/**
 * Copyright
 */
package com.kangyl.test.annotation;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/10/4
 */
public class TestDataApi extends TestSuper{

    @MyFiedAnno(value = "zhangsan",maxLength = 20,minLength = 10)
    private String name;

    @MyFiedAnno(value = "xx中学",maxLength = 20,minLength = 10)
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
