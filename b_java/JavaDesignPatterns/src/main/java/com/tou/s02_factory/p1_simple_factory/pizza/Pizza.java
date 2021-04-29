package com.tou.s02_factory.p1_simple_factory.pizza;

import lombok.Data;

/**
 * 将 Pizza 类 做成 抽象类
 */
@Data
public abstract class Pizza {
    protected String name;

    public abstract void prepare(); // 准备原材料

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " baking;");
    }

    public void box() {
        System.out.println(name + " baking;");
    }


}
