package com.tou.s16_observer.improve;

// 接口，让 WeatherData来实现
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
