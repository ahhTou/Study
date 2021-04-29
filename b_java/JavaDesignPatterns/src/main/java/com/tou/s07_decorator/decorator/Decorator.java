package com.tou.s07_decorator.decorator;

import com.tou.s07_decorator.Drink;

public class Decorator extends Drink {
    private final Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.price;
    }

    @Override
    public String getDes() {
        return des + " " + super.getPrice() + " && " + obj.getDes();
    }
}
