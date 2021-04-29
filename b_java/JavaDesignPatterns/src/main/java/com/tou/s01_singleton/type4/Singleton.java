package com.tou.s01_singleton.type4;

/**
 * 懒汉式 - 线程安全
 * 1. 效率低下
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 提供一个静态的公用方法 当使用到该方法时才去创建instance
    public static synchronized Singleton getInstance() {
        if (instance == null) return new Singleton();
        return instance;
    }

}
