package com.tou.s11_proxy.p3_cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory<T> implements MethodInterceptor {

    // 维护一个目标对象
    private T target;

    public ProxyFactory() {
        System.out.println("hello");
    }

    public ProxyFactory(T target) {
        System.out.println("> 工厂初始化");
        this.target = target;
    }


    /*
     * 返回一个代理对象
     * */
    @SuppressWarnings("unchecked")
    public T getProxyInstance() {
        // 1. 创建一个工具类
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类
        enhancer.setSuperclass(target.getClass());

        // 3. 设置回调函数
        enhancer.setCallback(this);

        // 4. 创建子类对象， 既子类对象
        return (T) enhancer.create();
    }

    /**
     * 重写 intercept 方法， 会调用 目标对象 的方法
     *
     * @param o           ？
     * @param method      ？
     * @param args        参数
     * @param methodProxy ？
     * @return 代理对象方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("> Cglib 代理模式 开始了");
        Object res = method.invoke(target, args);
        System.out.println("> Cglib 代理模式 提交了");
        return res;
    }
}
