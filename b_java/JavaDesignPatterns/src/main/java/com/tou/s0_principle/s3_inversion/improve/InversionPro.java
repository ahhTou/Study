package com.tou.s0_principle.s3_inversion.improve;

public class InversionPro {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}


/**
 * 定义接口
 */
interface IReceiver {
    public String getInfo();
}

class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信： Hello WeChat";
    }
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件 ： Hello World";
    }
}

/**
 * 完成Person
 * 方式2
 */
class Person {
    public void receive(IReceiver i) {
        System.out.println(i.getInfo());
    }
}
