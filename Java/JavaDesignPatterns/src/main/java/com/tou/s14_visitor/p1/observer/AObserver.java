package com.tou.s14_visitor.p1.observer;

import com.tou.s14_visitor.p1.MySubject;

public class AObserver extends MyObserver {

    public AObserver(MySubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(
                "AObserver 检查到升级 -> " + subject.getState()
        );
    }
}
