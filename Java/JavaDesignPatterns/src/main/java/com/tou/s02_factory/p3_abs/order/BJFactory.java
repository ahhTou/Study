package com.tou.s02_factory.p3_abs.order;

import com.tou.s02_factory.p3_abs.pizza.BJCheesePizza;
import com.tou.s02_factory.p3_abs.pizza.BJPepperPizza;
import com.tou.s02_factory.p3_abs.pizza.Pizza;

public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("Cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
