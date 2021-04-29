package com.tou.s02_factory.p1_simple_factory.order;

/**
 * 相当于一个客户端
 */
public class PizzaStore {
    public static void main(String[] args) {
        // new OrderPizza();

        // 使用简单工厂模式
        System.out.println(" 简单工厂 ");
        new OrderPizza(new SimpleFactory());
        System.out.println("- -- 退出程序 -- -");
    }
}
