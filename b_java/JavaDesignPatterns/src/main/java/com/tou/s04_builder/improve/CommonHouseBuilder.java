package com.tou.s4_builder.improve;

public class CommonHouseBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("打地基 5m");
    }

    @Override
    public void buildWalls() {
        System.out.println("砌墙 10cm");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
