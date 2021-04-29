package com.tou.s07_decorator.decorator;

import com.tou.s07_decorator.Drink;

public class Milk extends Decorator {

    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛奶 ");
        setPrice(2.0f);

    }
}
