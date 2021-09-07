package com.tou.s18_memento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();

        Caretaker caretaker = new Caretaker();

        originator.setState("- 状态 #1 攻击力是 100");

        caretaker.add(originator.saveStateMemento());

        originator.setState("- 状态 #2 攻击力是 80");

        caretaker.add(originator.saveStateMemento());

        originator.setState("- 状态 #3 攻击力是 300");

        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是 = " + originator.getState());

        // 得到状态 1
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("恢复到状态#1 " + originator.getState());


    }
}
