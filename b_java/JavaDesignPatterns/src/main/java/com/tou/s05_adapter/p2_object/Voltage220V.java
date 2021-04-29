package com.tou.s05_adapter.p2_object;

/**
 * 被适配的类
 */
public class Voltage220V {

    // 220v
    public int output220V() {
        int src = 220;
        System.out.println("电压 = " + src + "伏");
        return src;
    }

}
