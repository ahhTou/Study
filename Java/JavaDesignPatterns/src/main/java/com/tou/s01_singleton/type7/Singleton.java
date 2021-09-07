package com.tou.s01_singleton.type7;

/**
 * 单例模式 - 静态内部类
 */
public class Singleton {
    private Singleton() {
    }

    // 初始化时， 内部类不会被加载
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
