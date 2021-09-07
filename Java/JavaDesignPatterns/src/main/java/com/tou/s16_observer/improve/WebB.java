package com.tou.s16_observer.improve;

/**
 * 显示当前的天气情况，可以理解为气象站自己的网站
 */
public class WebB implements Observer {
    private float temperature;

    private float pressure;

    private float humidity;


    // 更新 天气情况， 是由WeatherData 来调用，我使用推送模式
    public void update(float t, float p, float h) {
        System.out.println("* B 网站收到了更新");
        this.temperature = t;
        this.pressure = p;
        this.humidity = h;
        display();
    }

    public void display() {
        System.out.println("- 今天的温度是 " + temperature);
        System.out.println("- 今天的气压是 " + pressure);
        System.out.println("- 今天的湿度是 " + humidity);
    }
}
