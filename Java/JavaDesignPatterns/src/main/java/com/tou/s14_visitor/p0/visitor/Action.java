package com.tou.s14_visitor.p0.visitor;

import com.tou.s14_visitor.p0.element.Man;
import com.tou.s14_visitor.p0.element.Woman;

public abstract class Action {

    // 得到男性 的测评结果
    public abstract void getManResult(Man man);

    // 得到女性 的测评结果
    public abstract void getWomanResult(Woman woman);
}
