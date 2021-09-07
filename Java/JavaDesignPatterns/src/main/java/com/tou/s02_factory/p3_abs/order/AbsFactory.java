package com.tou.s02_factory.p3_abs.order;

import com.tou.s02_factory.p3_abs.pizza.Pizza;

/**
 * 抽象工厂模式的抽象层
 */
public interface AbsFactory {

    // 让下面的工厂子类 来具体实现
    public Pizza createPizza(String orderType);
}
