package com.tou.s14_visitor.p0.element;

import com.tou.s14_visitor.p0.visitor.Action;

public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
