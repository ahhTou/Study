package com.tou.s02_factory.p2_factory_method.order;

import com.tou.s02_factory.p2_factory_method.pizza.BJCheesePizza;
import com.tou.s02_factory.p2_factory_method.pizza.BJPepperPizza;
import com.tou.s02_factory.p2_factory_method.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("Cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
