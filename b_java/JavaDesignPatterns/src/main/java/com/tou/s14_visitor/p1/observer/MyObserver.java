package com.tou.s14_visitor.p1.observer;

import com.tou.s14_visitor.p1.MySubject;

public abstract class MyObserver {
    protected MySubject subject;

    public abstract void update();
}
