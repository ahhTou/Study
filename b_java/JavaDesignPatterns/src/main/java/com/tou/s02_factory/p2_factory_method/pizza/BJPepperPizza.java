package com.tou.s02_factory.p2_factory_method.pizza;

public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京胡椒pizza");
        System.out.println("给 北京的胡椒pizza 准备 原材料");
    }

}
