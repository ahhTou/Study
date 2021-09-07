package com.tou.s02_factory.p2_factory_method.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒pizza");
        System.out.println("给 伦敦胡椒pizza 准备 原材料");
    }
}
