package com.tou.s02_factory.p1_simple_factory.pizza;

public class PepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给 Pepper 披萨 准备食材");
    }
}
