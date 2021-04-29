package com.tou.s02_factory.p1_simple_factory.order;

import com.tou.s02_factory.p1_simple_factory.pizza.CheesePizza;
import com.tou.s02_factory.p1_simple_factory.pizza.GreekPizza;
import com.tou.s02_factory.p1_simple_factory.pizza.Pizza;

public class SimpleFactory {

    public Pizza createPizza(String type) {
        System.out.println("使用简单工厂模式 ");
        Pizza pizza = null;

        if (type.equals("Greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (type.equals("Cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }

        return pizza;
    }

}
