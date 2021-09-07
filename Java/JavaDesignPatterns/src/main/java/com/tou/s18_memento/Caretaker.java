package com.tou.s18_memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 守护者对象
 *
 */
public class Caretaker {

    // 在 List 集合中要有很多备忘录对象
    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    // 获取到第index个Originator 的备忘录对象(即保存状态)
    public Memento get(int index) {
        return mementoList.get(index);
    }

}
