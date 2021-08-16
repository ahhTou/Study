package com.tou.spring_lite;

public class Client {
    public static void main(String[] args) {
        MyContext myContext = new MyContext("com.tou.spring_lite.entity");

        Object account = myContext.getBean("account");
        Object order = myContext.getBean("myOrder");
        System.out.println(account);
        System.out.println(order);
    }
}
