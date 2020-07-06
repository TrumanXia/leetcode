package proxy.gupao.com.gupao.vip.proxy.gpproxy;

import java.lang.reflect.Method;


public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
