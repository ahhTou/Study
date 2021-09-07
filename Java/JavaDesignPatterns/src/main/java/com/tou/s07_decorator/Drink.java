package com.tou.s07_decorator;

import lombok.Data;

@Data
public abstract class Drink {

    // 描述
    public String des;

    // 价格
    public float price = 0.0f;

    public abstract float cost();
}
