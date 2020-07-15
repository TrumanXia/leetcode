package mybatis.plugin.myPlugin.v2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装的反射需要使用的属性
 *
 * @author 97994
 * @since 22:09
 */
public class Invocation {
    private Object target;
    private Method method;
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, args);
    }
}
