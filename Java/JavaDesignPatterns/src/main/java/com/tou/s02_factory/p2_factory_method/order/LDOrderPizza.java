package com.tou.s02_factory.p2_factory_method.order;

import com.tou.s02_factory.p2_factory_method.pizza.LDCheesePizza;
import com.tou.s02_factory.p2_factory_method.pizza.LDPepperPizza;
import com.tou.s02_factory.p2_factory_method.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("Cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
