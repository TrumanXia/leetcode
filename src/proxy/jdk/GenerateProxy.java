package proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class GenerateProxy {
    public static void main(String[] args) throws Exception {
//        JDK的动态代理，被代理的类必须要实现接口
        /*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Proxyee.class});
        FileOutputStream outputStream
            = new FileOutputStream("E:\\EclipseWorkspace2\\leetcode\\temp\\$Proxy0.class");
        outputStream.write(bytes);
        outputStream.close();*/

//        JDK的动态代理，被代理的类必须要实现接口
        /*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy1", new Class[]{ProxyeeImpl.class});
        FileOutputStream outputStream
            = new FileOutputStream("E:\\EclipseWorkspace2\\leetcode\\temp\\$Proxy1.class");
        outputStream.write(bytes);
        outputStream.close();*/

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy1", new Class[]{GenerateProxy.class});
        FileOutputStream outputStream
            = new FileOutputStream("E:\\EclipseWorkspace2\\leetcode\\temp\\$Proxy1.class");
        outputStream.write(bytes);
        outputStream.close();
    }
}
