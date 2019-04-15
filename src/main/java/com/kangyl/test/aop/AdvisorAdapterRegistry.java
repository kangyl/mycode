package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public interface AdvisorAdapterRegistry {

    Advisor wrap(Object advice);

    void registerAdapter(AdvisorAdapter advisorAdapter);

    MethodInterceptor[] getInterceptors(Advisor advisor);

}
