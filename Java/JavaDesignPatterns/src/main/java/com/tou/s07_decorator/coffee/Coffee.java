package com.tou.s07_decorator.coffee;

import com.tou.s07_decorator.Drink;

public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
