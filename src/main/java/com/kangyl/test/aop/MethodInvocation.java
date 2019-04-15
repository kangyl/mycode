package com.kangyl.test.aop;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2019年04月12日
 */
public interface MethodInvocation {

    /**
     * 方法执行
     * @return
     */
    Object invoke();

    /**
     * 获取被代理的对象
     * @return
     */
    Object getTarget();

    /**
     * 获取参数集
     * @return
     */
    Object[] getArguments();

}
