package com.tou.s00_principle.s4_liskov;

public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.func1(11, 3));
        System.out.println("1 - 8 = " + a.func1(1, 8));

        System.out.println("-----");
        B b = new B();
        System.out.println("11 - 3 = " + b.func1(11, 3));
        System.out.println("1 - 8 = " + b.func1(1, 8));

    }
}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * B 继承了 A
 * 增加了一个新功能，完成了两个数相加， 并加 9
 */
class B extends A {

    // 无意重写，导致程序出错
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}


