package com.tou.s18_memento;

import lombok.Data;

/**
 * 对象，需要保存状态的对象
 */
@Data
public class Originator {
    private String state;

    // 编写一个方法，可以保存一个状态对象Memento
    // 因此编写一个方法，返回Memento
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    // 通过备忘录对象，恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
