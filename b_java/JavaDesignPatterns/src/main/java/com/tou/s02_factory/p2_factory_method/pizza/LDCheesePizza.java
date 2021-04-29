package com.tou.s02_factory.p2_factory_method.pizza;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println("给 伦敦奶酪pizza 准备 原材料");
    }
}
