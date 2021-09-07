package com.tou.s4_builder;

public abstract class AbsHouse {

    // 打地基
    public abstract void buildBasic();

    // 砌墙
    public abstract void buildWails();

    // 封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWails();
        roofed();
    }
}
