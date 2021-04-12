package com.tou.s0_principle.s1_single_responsibility;

public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.runWater("轮船");
        vehicle2.runAir("飞机");
    }

}

/**
 * 方式3
 * 1. 这种修改方法没有对原来的类做打的修改，只是增加方法
 * 2. 这里虽然没有在类的级别上遵守单一职责原则，但是方法级别上遵守了
 */
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在Air上跑");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在water上跑");
    }
}
