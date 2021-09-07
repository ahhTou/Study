package com.tou.s07_decorator;

import com.tou.s07_decorator.coffee.LongBlack;
import com.tou.s07_decorator.decorator.Chocolate;
import com.tou.s07_decorator.decorator.Milk;
public class CoffeeBar {
    public static void main(String[] args) {
        // 订单 ： 2个巧克力 + 一份牛奶 的 LongBlack

        // 1. 创建
        Drink order = new LongBlack();

        System.out.println("费用 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

        order = new Milk(order);

        System.out.println("费用 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

        order = new Chocolate(order);
        System.out.println("费用 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

        order = new Chocolate(order);
        System.out.println("费用 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

    }
}
