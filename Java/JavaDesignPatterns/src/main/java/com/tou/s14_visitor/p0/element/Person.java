package com.tou.s14_visitor.p0.element;

import com.tou.s14_visitor.p0.visitor.Action;

public abstract class Person {
    // 提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}
