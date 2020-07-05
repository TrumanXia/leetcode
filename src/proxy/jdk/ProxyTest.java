package proxy.jdk;

public class ProxyTest {
    public static void main(String[] args) {
//        new ProxyeeImpl().a();
//        不能针对类进行代理
//        ProxyeeImpl proxy = (ProxyeeImpl) new ProxyHandler().getProxy(new ProxyeeImpl());
//        jdk只能针对接口进行代理
        Proxyee proxy = (Proxyee) new ProxyHandler().getProxy(new ProxyeeImpl());
        proxy.a();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put("sum.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }
}
