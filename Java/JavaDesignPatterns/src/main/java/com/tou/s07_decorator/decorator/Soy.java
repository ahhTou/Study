package com.tou.s07_decorator.decorator;

import com.tou.s07_decorator.Drink;

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
