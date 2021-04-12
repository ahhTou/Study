package com.tou.s0_principle.s1_single_responsibility;

public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle r = new RoadVehicle();
        WaterVehicle w = new WaterVehicle();
        AirVehicle a = new AirVehicle();

        a.run("飞机");
        w.run("邮轮");
        r.run("汽车");
    }
}

/**
 * 方案2
 * 1. 遵守了单一职责原则
 * 2. 但是这也改动分大，即将类分解，同时修改客户端
 * 3. 改进：直接修改Vehicle 类， 改动的代码会比较少
 */
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }


}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空中运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空中运行");
    }
}
