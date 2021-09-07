package com.tou.s07_decorator.decorator;

import com.tou.s07_decorator.Drink;

/**
 * 具体的Decorator ， 调味品
 */
public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f);
    }
}
