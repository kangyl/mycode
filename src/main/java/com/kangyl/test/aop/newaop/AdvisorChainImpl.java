package com.kangyl.test.aop.newaop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/15
 */
public class AdvisorChainImpl implements AdvisorChain{

    private List<Advisor> advisors;

    public AdvisorChainImpl(List<Advisor> advisors){
        this.advisors = advisors;

    }

    @Override
    public void doMethodBefore(Method method, Class clazz,Object target) {
        List<Advisor> matchAdvisor = getMatchAdvisor(method, clazz);
        for (Advisor advisor : matchAdvisor) {
            Advice advice = advisor.getAdvice();
            if(isBeforeAdvice(advice)){
                ((MethodBeforeAdvice)advice).before(method,target);
            }
        }
    }

    @Override
    public void doMethodAfter(Object result, Method method, Class clazz,Object[] args,Object target) {
        List<Advisor> matchAdvisor = getMatchAdvisor(method, clazz);
        for (Advisor advisor : matchAdvisor) {
            Advice advice = advisor.getAdvice();
            if(isAfterAdvice(advice)){
                ((MethodAfterAdvice)advice).after(result,method,args,target);
            }
        }
    }

    private List<Advisor> getMatchAdvisor(Method method,Class clazz){
        List<Advisor> result = new ArrayList<>();
        for (Advisor advisor : advisors) {
            Pointcut pointcut = advisor.getPointcut();
            boolean match = pointcut.getClassFilter().match(clazz) && pointcut.getMethodFilter().match(method, clazz);
            if(match){
                result.add(advisor);
            }
        }
        return result;
    }

    private boolean isBeforeAdvice(Advice advice){
        return advice instanceof MethodBeforeAdvice;
    }

    private boolean isAfterAdvice(Advice advice) {
        return advice instanceof MethodAfterAdvice;
    }
}
