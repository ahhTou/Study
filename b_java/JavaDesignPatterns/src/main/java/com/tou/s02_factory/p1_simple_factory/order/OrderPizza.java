package com.tou.s02_factory.p1_simple_factory.order;

import com.tou.s02_factory.p1_simple_factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType;
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购pizza 失败");
                break;
            }
        } while (true);
    }

    /**
     * 可以获取客服希望订购的披萨种类
     */
    private String getType() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input pizza type : ");
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
