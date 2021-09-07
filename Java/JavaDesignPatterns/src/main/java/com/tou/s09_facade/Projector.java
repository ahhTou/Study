package com.tou.s09_facade;

public class Projector {
    private static final Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Projector on ");
    }

    public void off() {
        System.out.println(" Projector off ");
    }

    public void pop() {
        System.out.println(" Projector pop ");
    }
}
