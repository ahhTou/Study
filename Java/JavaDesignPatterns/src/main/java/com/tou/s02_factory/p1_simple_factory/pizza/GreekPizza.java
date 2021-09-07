package com.tou.s02_factory.p1_simple_factory.pizza;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给制作披萨 准备食材");
    }
}
