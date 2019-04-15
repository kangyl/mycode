package com.kangyl.test.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public class DefaultAdvisorAdapterRegistry implements AdvisorAdapterRegistry {

    public static DefaultAdvisorAdapterRegistry instance = new DefaultAdvisorAdapterRegistry();

    private final List<AdvisorAdapter> adapters = new ArrayList<>(5);

    @Override
    public Advisor wrap(Object advice) {
        return null;
    }

    @Override
    public void registerAdapter(AdvisorAdapter advisorAdapter) {
        this.adapters.add(advisorAdapter);
    }

    @Override
    public MethodInterceptor[] getInterceptors(Advisor advisor) {
        return new MethodInterceptor[0];
    }
}
