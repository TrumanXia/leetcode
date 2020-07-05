package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    private Object target;
//    proxy怎么使用的？
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
//        proxy是代理类，不能invoke，这样会死循环
//        Object object = method.invoke(proxy, args);
        Object result = method.invoke(target, args);
        System.out.println("代理后");
//        但是proxy可以被返回性成链式调用
        return result;
    }

//    获得代理对象
    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
    }
}
