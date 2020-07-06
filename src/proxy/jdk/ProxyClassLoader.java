package proxy.jdk;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ProxyClassLoader extends ClassLoader{
    public static void main(String[] args) {
        URLClassLoader loader = null;
        try {
            // create a URLClassLoader
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File("E:\\EclipseWorkspace2\\leetcode\\temp");
            // the forming of repository is taken from the createClassLoader method in
            // org.apache.catalina.startup.ClassLoaderFactory
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
            // the code for forming the URL is taken from the addRepository method in
            // org.apache.catalina.loader.StandardClassLoader class.
//            null 有null的用途
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        }
        catch (IOException e) {
            System.out.println(e.toString() );
        }
        Class myClass = null;
        try {
//            查找class文件时，不要加 .class后缀名
            myClass = loader.loadClass("$Proxy0");
            Constructor constructor = myClass.getConstructor(InvocationHandler.class);
//            返回任意一个类，当然是用动态代理肯定不会这么做的
            InvocationHandler invocationHandler = (proxy, method, args1) -> new ProxyeeImpl();
            Object o = constructor.newInstance(invocationHandler);
            System.out.println(o);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
