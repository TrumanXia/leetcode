package mybatis.plugin.myPlugin.v2;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 97994
 * @since 2020-07-11
 */
public interface InterceptorV2 {
    Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    Object plugin(Object target);
}
