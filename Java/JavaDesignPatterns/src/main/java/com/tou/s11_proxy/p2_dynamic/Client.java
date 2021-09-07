package com.tou.s11_proxy.p2_dynamic;

public class Client {
    public static void main(String[] args) {
        ProxyFactory<ITeacherDao> proxy = new ProxyFactory<>(new TeacherDao());

        ITeacherDao proxyInstance = proxy.getProxyInstance();

        // 内存中动态生成了代理对象
        proxyInstance.teach();
    }
}
