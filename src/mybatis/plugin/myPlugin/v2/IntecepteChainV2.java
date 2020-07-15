package mybatis.plugin.myPlugin.v2;

import java.util.ArrayList;
import java.util.List;

// 拦截器的数量肯定是不受限制的，所有提供一个拦截器的容器，以及统一为所有的拦截器生成代理的方法。
public class IntecepteChainV2 {
    List<InterceptorV2> chain = new ArrayList<>();

    public void addIntecepe(InterceptorV2 interceptor) {
        chain.add(interceptor);
    }

    public Object pluginAll(Object target) {
        for (InterceptorV2 interceptor : chain) {
            target = interceptor.plugin(target);
        }
        return target;
    }
}
