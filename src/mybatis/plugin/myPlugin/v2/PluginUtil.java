package mybatis.plugin.myPlugin.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 此类与pugao实现的里面的Plugin类似，但我觉得叫这个名称更准确些
 */
public class PluginUtil implements InvocationHandler {
    private InterceptorV2 interceptor;
    private Object target;

    public PluginUtil(Object target, InterceptorV2 interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public static Object wrap(Object target, InterceptorV2 interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            new PluginUtil(target, interceptor));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.intercept(new Invocation(target, method, args));
    }
}
