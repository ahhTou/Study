package com.tou;

public class MyTest {
    public static void main(String[] args) {
        Son a = new Son();
        a.say();
        a.sonSay();
    }
}

abstract class Father {
    public Father() {
        System.out.println(this);
    }

    public void say() {
        System.out.println(this);
    }


}

class Son extends Father {
    public Son() {
    }

    public void sonSay() {
        System.out.println(this);
    }
}
