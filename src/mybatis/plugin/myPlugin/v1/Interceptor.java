package com.wufeng.WKbatis.v2.plugin.myPlugin.v1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Interceptor {
//    拦截 核心方法, 拦截好了还是要返回对象
    Object intercept(Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
    /**
     *
     * @param target 被拦截对象
     * @return
     */
    Object plugin(Object target);
}
