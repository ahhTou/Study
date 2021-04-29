package com.tou.s00_principle.s4_liskov.impove;

public class LiskovPro {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.func1(11, 3));
        System.out.println("1 - 8 = " + a.func1(1, 8));

        System.out.println("-----");
        B b = new B();
        // 因为B类不再继承A类，因此调用者，不会再认为fun1是求减法
        System.out.println("11 + 3 = " + b.func1(11, 3));
        System.out.println("1 + 8 = " + b.func1(1, 8));

        // 使用组合 利用 A 相减
        System.out.println("11 - 3 = " + b.func3(11, 3));
    }

}


// 创建一个更加基础的基类
class Base {
    // 把更加基础的方法和成员写道Base类中

}

class A extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {
    private final A a = new A();

    // 无意重写，导致程序出错
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    // 我们仍然想使用A的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}
