package com.tou.s14_visitor.p1;

import com.tou.s14_visitor.p1.observer.AObserver;

public class Client {
    public static void main(String[] args) {


        MySubject mySubject = new MySubject();

        new AObserver(mySubject);

        mySubject.setState(30);

    }
}
