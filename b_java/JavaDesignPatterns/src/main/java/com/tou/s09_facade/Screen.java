package com.tou.s09_facade;

public class Screen {
    private static final Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Screen on ");
    }

    public void down() {
        System.out.println(" Screen off ");
    }
}
