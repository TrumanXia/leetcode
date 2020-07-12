package com.wufeng.WKbatis.v2.plugin.myPlugin.v1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimplePlugin2 implements Interceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args)
        throws InvocationTargetException, IllegalAccessException {
        System.out.println("haha2");
        return method.invoke(target, args);
    }

    /**
     * 委托给Plugin对象来处理，直接使用Proxy.new方法
     *
     * @param target 被拦截对象
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (proxy, method, args) -> {
//                    内部类与外部类通信的方式
                return SimplePlugin2.this.intercept(target, method, args);
            });
    }
}
