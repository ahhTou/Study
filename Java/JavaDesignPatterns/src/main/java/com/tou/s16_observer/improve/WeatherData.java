package com.tou.s16_observer.improve;

import lombok.Data;

import java.util.ArrayList;

/**
 * 核心类
 * 1. 包含了最新的天气情况
 * 2. 含有 观察者接口，使用ArrayList管理
 * 3. 当对象有更新时，就主动调 ArrayList, 通知所有的接入方就可以看到最新的消息
 */
@Data
public class WeatherData implements Subject {
    private float temperature;

    private float pressure;

    private float humidity;

    // 观察者集合
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    // 当数据有更新时，就调用setData
    public void setData(float t, float p, float h) {
        this.temperature = t;
        this.pressure = p;
        this.humidity = h;
        dataChange(); // 将最最新的信息推送给接收方
    }

    private void dataChange() {
        System.out.println("* 硬件收到更新 将更新所有观察者");
        notifyObserver();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // 遍历所有的观察者，并通知
    @Override
    public void notifyObserver() {
        observers.forEach(e -> e.update(getTemperature(), getPressure(), getHumidity()));
    }
}
