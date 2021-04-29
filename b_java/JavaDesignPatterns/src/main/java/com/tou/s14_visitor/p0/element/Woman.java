package com.tou.s14_visitor.p0.element;

import com.tou.s14_visitor.p0.visitor.Action;

/**
 * 1. 这里我们使用双分派，即首先在客户端程序中，将具体的状态作为参数传递到Woman 中 （第一次分派）
 * 2. 然后Woman类调用了作为参数的 “具体方法” 中 方法getWomanResult,同时将this作为参数
 * 传入，完成第二次分派
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
