package com.tou.s09_facade;

public class TheaterLight {
    private static final TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" TheaterLight on ");
    }

    public void off() {
        System.out.println(" TheaterLight off ");
    }

    public void dim() {
        System.out.println(" TheaterLight is dim ");
    }

    public void bright() {
        System.out.println(" TheaterLight is bright ");

    }
}
