package com.tou.s14_visitor.p1;

import com.tou.s14_visitor.p1.observer.MyObserver;

import java.util.ArrayList;
import java.util.List;

public class MySubject {
    private final List<MyObserver> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(MyObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.update();
        }
    }
}
