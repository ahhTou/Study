package com.tou.s02_factory.p2_factory_method.order;


import com.tou.s02_factory.p2_factory_method.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    /**
     * 定义一个抽象方法 createPizza 让各个工厂子类自己实现
     */
    abstract Pizza createPizza(String orderType);


    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            pizza = this.createPizza(orderType);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
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
