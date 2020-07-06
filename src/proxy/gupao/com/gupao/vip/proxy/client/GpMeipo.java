package proxy.gupao.com.gupao.vip.proxy.client;


import proxy.gupao.com.gupao.vip.proxy.gpproxy.GPClassLoader;
import proxy.gupao.com.gupao.vip.proxy.gpproxy.GPInvocationHandler;
import proxy.gupao.com.gupao.vip.proxy.gpproxy.GPProxy;

import java.lang.reflect.Method;

/**
 * Created by Tom.
 */
public class GpMeipo implements GPInvocationHandler {
//    private IPerson target;
    private Animal target;
//    public IPerson getInstance(IPerson target){
//        this.target = target;
//        Class<?> clazz =  target.getClass();
//        System.out.println(clazz.getClasses().length);
//        return (IPerson) GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
//    }

    public Animal getInstance(Dog target){
        this.target = target;
        Class<?> clazz =  target.getClass();
//        System.out.println(clazz.getClasses().length);
        return (Animal) GPProxy.newProxyInstance(new GPClassLoader(), new Class[]{clazz.getSuperclass()},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始交往");
    }

    private void before() {
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }
}
