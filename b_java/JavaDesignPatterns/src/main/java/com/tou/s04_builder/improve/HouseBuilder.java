package com.tou.s4_builder.improve;

import org.omg.CORBA.PUBLIC_MEMBER;

public abstract class HouseBuilder {
    protected House house = new House();


    /**
     * 将建造的流程鞋号，抽象的方法
     */
    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    // 建造房子
    public House buildHouse() {
        return house;
    }

}
