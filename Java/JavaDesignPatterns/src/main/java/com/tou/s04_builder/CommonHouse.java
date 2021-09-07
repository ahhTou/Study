package com.tou.s4_builder;

public class CommonHouse extends AbsHouse {
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子`打地基");
    }

    @Override
    public void buildWails() {
        System.out.println(" 普通房子砌墙");

    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶");

    }
}
