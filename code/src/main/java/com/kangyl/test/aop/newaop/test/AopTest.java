package com.kangyl.test.aop.newaop.test;

import com.kangyl.test.aop.newaop.AdvisorRegistry;
import com.kangyl.test.aop.newaop.ProxyFactory;
import com.kangyl.test.aop.newaop.impl.MethodAfterAdvisor;
import com.kangyl.test.aop.newaop.impl.MethodBeforeAdvisor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class AopTest {

    public static void main(String[] args) {
        MethodBeforeAdvisor methodBeforeAdvisor = new MethodBeforeAdvisor();
        MethodAfterAdvisor methodAfterAdvisor = new MethodAfterAdvisor();
        AdvisorRegistry.register(methodBeforeAdvisor);
        AdvisorRegistry.register(methodAfterAdvisor);

        TestInterface testInterface = new TestInterfaceImpl();
        TestInterface proxy = ProxyFactory.getProxy(testInterface);
        proxy.before();
        proxy.after();
    }
}
