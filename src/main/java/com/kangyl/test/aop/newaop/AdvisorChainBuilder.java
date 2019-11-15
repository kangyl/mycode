package com.kangyl.test.aop.newaop;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class AdvisorChainBuilder {

    public static AdvisorChain buildChain(){
        return new AdvisorChainImpl(AdvisorRegistry.getAdvisors());
    }
}
