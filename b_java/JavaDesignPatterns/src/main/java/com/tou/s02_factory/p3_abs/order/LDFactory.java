package com.tou.s02_factory.p3_abs.order;

import com.tou.s02_factory.p3_abs.pizza.BJCheesePizza;
import com.tou.s02_factory.p3_abs.pizza.LDCheesePizza;
import com.tou.s02_factory.p3_abs.pizza.Pizza;

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("Cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJCheesePizza();
        }
        return pizza;
    }
}
