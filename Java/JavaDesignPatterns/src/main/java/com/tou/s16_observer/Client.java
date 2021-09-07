package com.tou.s16_observer;

public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);

        weatherData.setData(30, 150, 40);

    }
}
