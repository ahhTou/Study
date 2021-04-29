package com.tou.s00_principle.s1_single_responsibility;

/**
 * 单一原则
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");

        vehicle.run("飞机");

    }
}


/**
 * 交通工具类
 * 方式1
 * 1. 在方式1 的 run 方法中 违法了单一职责原则
 * 2. 解决的方案非常简单， 根据交通的运行方法不同分解成不同的即可
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}
