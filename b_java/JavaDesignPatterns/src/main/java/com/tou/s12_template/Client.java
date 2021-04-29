package com.tou.s12_template;

public class Client {
    public static void main(String[] args) {
        SoYaMilk red = new RedBeanSoYaMilk();
        red.make();

        SoYaMilk peanut = new PeanutSoYaMilk();
        peanut.make();
    }
}
