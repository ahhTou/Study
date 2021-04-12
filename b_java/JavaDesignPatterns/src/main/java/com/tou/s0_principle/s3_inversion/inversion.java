package com.tou.s0_principle.s3_inversion;

public class inversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}


/**
 * 完成Person
 * 方式1
 * 1. 简单，容易想到
 * 2. 如果我们获取的对象是微信，短信等等， 则要新增类，同时Person新增相应的方法
 * 3. 解决思路 ： 引入一个抽象的接口 IReceiver， 表示接收者， 这样Person类与接口发生依赖
 *      因为Email WeiXin 等等属于接受的范围，他们各自实现IReceiver 接口就Ok了，这样我们
 *      就符合 依赖倒转原则。
 */
class Email {
    public String getInfo() {
        return "电子邮件 ： Hello World";
    }
}

class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
