package com.tou.s5_adapter.p1_class;

public class Phone {

    // 充电的方法
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5)
            System.out.println("充电成功");
        else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压过高！无法充电");
        }
    }

}
