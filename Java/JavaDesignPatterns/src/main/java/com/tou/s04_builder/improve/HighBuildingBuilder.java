package com.tou.s4_builder.improve;

public class HighBuildingBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("打地基 100m");
    }

    @Override
    public void buildWalls() {
        System.out.println("砌墙 20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶");
    }
}
