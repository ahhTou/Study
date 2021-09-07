package com.tou.s05_adapter.p2_object;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 适配器类
 */
@AllArgsConstructor
@Data
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V output220V;

    @Override
    public int output5V() {
        int dst = 0;
        if (null != output220V) {
            int scr = output220V.output220V();
            System.out.println("对象适配器 ：220v -> 5v ");
            dst = scr / 44;
            System.out.println("适配完成，输出的电压 = " + dst);
        }

        return dst;
    }
}
