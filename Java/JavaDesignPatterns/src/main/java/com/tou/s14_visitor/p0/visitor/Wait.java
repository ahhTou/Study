package com.tou.s14_visitor.p0.visitor;

import com.tou.s14_visitor.p0.element.Man;
import com.tou.s14_visitor.p0.element.Woman;

public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价是该歌手评价待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价是该歌手评价待定");
    }
}
