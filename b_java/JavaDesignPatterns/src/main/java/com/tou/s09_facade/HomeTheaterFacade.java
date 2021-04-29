package com.tou.s09_facade;

public class HomeTheaterFacade {
    // 定义各个子系统的对象
    private final TheaterLight theaterLight;
    private final Popcorn popcorn;
    private final Stereo stereo;
    private final Projector projector;
    private final Screen screen;
    private final DVDPlayer dvdPlayer;

    public HomeTheaterFacade() {
        super();
        this.theaterLight = TheaterLight.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.popcorn = Popcorn.getInstance();

    }

    public void ready() {
        popcorn.on();
        popcorn.pop();

        screen.on();
        stereo.on();

        dvdPlayer.on();
        theaterLight.dim();

    }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popcorn.off();
        theaterLight.bright();
        screen.down();
        stereo.off();
        dvdPlayer.on();
        theaterLight.dim();
    }


}
