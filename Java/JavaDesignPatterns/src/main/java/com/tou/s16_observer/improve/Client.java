package com.tou.s16_observer.improve;


public class Client {
    public static void main(String[] args) {
        // 创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        // 创建观察者
        weatherData.registerObserver(new WebA());
        weatherData.registerObserver(new WebB());


        weatherData.setData(10, 20, 30);
    }
}
