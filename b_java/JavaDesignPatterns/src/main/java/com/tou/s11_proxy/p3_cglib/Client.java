package com.tou.s11_proxy.p3_cglib;

public class Client {

    public static void main(String[] args) {
        ProxyFactory<TeacherDao> teach = new ProxyFactory<>(new TeacherDao());

        TeacherDao proxyInstance = teach.getProxyInstance();

        proxyInstance.teach();

    }
}
