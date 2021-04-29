package com.tou.s01_singleton.type1;

/**
 * 饿汉式 - 静态变量
 */
class Singleton {


    // 1. 构造器私有化，外部不能new
    private Singleton() {
    }

    // 2. 本列内部创建对象实例
    private static final Singleton instance = new Singleton();

    // 3. 提供一个共有的静态方法 ，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}
