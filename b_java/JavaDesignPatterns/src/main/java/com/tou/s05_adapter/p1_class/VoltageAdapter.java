package com.tou.s5_adapter.p1_class;

/**
 * 适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {


    @Override
    public int output5V() {
        // 获取220v的电压
        int srcV = output220V();
        int dst = srcV / 44;
        System.out.println("220v -> 5v");
        return dst;
    }
}
