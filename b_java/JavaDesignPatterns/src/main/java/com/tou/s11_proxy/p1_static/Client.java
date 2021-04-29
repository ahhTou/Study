package com.tou.s11_proxy.p1_static;

public class Client {

    public static void main(String[] args) {
        TeacherDaoProxy proxy = new TeacherDaoProxy(new TeacherDao());
        proxy.teach();

    }

}
