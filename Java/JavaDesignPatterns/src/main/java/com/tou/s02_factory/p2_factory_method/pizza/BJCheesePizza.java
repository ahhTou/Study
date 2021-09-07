package com.tou.s02_factory.p2_factory_method.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println("给 北京的奶酪pizza 准备 原材料");
    }
}
