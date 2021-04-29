package com.tou.s14_visitor.p0;

import com.tou.s14_visitor.p0.visitor.Action;
import com.tou.s14_visitor.p0.element.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * 数据结构，管理了很多人
 */
public class ObjectStructure {

    // 维护了一个集合
    private final List<Person> personArr = new LinkedList<>();

    // 增加到list
    public void attach(Person p) {
        personArr.add(p);
    }

    // 移除
    public void detach(Person p) {
        personArr.remove(p);
    }

    // 显示测评的情况
    public void display(Action action) {
        personArr.forEach(person -> person.accept(action));
    }
}
