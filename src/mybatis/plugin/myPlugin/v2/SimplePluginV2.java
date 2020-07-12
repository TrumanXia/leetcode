package com.wufeng.WKbatis.v2.plugin.myPlugin.v2;

import com.wufeng.WKbatis.v2.plugin.myPlugin.v1.Interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimplePluginV2 implements InterceptorV2 {
    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("haha");
        return invocation.proceed();
    }

    /**
     * 委托给Plugin对象来处理，直接使用Proxy.new方法
     *
     * @param target 被拦截对象
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return PluginUtil.wrap(target, this);
    }
}
