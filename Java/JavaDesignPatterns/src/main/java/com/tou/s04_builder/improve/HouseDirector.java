package com.tou.s4_builder.improve;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通过构造器传入、通过set传入
 */
@Data
@AllArgsConstructor
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    // 如何建造房子的流程，交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();

        return houseBuilder.buildHouse();
    }
}
