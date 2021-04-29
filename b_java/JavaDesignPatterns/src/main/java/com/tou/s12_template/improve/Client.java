package com.tou.s12_template.improve;


public class Client {


    public static void main(String[] args) {
        SoYaMilk red = new RedBeanSoYaMilk();
        red.make();

        SoYaMilk peanut = new PeanutSoYaMilk();
        peanut.make();

        SoYaMilk pure = new PureSoYaMilk();
        pure.make();
    }

}
