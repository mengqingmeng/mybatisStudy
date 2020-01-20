package dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        MyIntf proxyIntf =
                (MyIntf) Proxy.newProxyInstance(
                        MyIntf.class.getClassLoader(), // 类加载器
                        new Class[]{MyIntf.class},  // 待实现的数组接口
                        new MyInvocationHandler()); // 自定义Invocation实例
        proxyIntf.helloWorld();
    }
}
