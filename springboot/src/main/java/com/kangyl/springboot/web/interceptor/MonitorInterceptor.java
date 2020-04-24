package com.kangyl.springboot.web.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/1/2
 */
@Intercepts({@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
@Component
public class MonitorInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = invocation.proceed();
        stopWatch.stop();

        System.out.println("总计耗时:"+stopWatch.getTotalTimeMillis());
        return result;
    }
}
