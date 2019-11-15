package com.kangyl.test.aop.newaop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 切面注册
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class AdvisorRegistry {
    private static List<Advisor> advisorList = new ArrayList<>();
    private AdvisorRegistry(){}

    public synchronized static void register(Advisor advisor){
        advisorList.add(advisor);
    }

    public synchronized static List<Advisor> getAdvisors(){
        return Collections.unmodifiableList(advisorList);
    }
}
