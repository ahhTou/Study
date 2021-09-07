package com.tou.s09_facade;

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();

        homeTheaterFacade.ready();

        homeTheaterFacade.play();

        homeTheaterFacade.end();
    }
}
