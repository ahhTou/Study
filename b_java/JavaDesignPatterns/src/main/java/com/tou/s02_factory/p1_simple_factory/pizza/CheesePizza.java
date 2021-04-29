package com.tou.s02_factory.p1_simple_factory.pizza;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给制作奶酪披萨 准备食材");
    }
}
