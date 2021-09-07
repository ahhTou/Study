package com.tou.s11_proxy.p2_dynamic;

import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    private final T target;

    public ProxyFactory(T target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public T getProxyInstance() {
        /*
         * Proxy.newProxyInstance(loader, interfaces, h);
         * 参数介绍
         * ClassLoader loader : 指定当前对象使用的类加载器，获取这个加载器的方法固定
         * Class<?>[] interfaces : 目标对象它实现的接口类型，使用泛型的方式确认类型
         * InvocationHandler : 事情处理，执行目标的对象方式时，会触发事情处理方法作为参数传入
         */
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("* JDK 代理开始");
                    Object invoke = method.invoke(target, args);
                    System.out.println("* JDK 代理结束 / 提交");
                    return invoke;
                });
    }

}
