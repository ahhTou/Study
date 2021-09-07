package com.tou.s16_observer;

import lombok.Data;

/**
 * 核心类
 * 1. 包含了最新的天气情况
 * 2. 含有 CurrentConditions 对象
 * 3. 当对象有更新时，就主动调用 CurrentConditions 对象update方法 (含有display)
 * 这样就能看见最新的方法
 */
@Data
public class WeatherData {
    private float temperature;

    private float pressure;

    private float humidity;

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    // 当数据有更新时，就调用setData
    public void setData(float t, float p, float h) {
        this.temperature = t;
        this.pressure = p;
        this.humidity = h;
        dataChange(); // 将最最新的信息推送给接收方
    }

    private void dataChange() {
        System.out.println("* 硬件收到更新");
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }


}
