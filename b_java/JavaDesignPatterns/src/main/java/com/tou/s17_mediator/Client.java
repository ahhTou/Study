package com.tou.s17_mediator;

public class Client {
    public static void main(String[] args) {
        User john = new User("John");

        User jack = new User("Jack");

        jack.sendMessage("hi john");
        john.sendMessage("hi jack");
    }
}
