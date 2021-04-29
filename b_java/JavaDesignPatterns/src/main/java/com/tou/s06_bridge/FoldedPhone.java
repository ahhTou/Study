package com.tou.s06_bridge;

/**
 * 折叠手机
 */
public class FoldedPhone extends Phone {
    // 构造器
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        System.out.println("折叠手机");
        super.open();
    }

    public void close() {
        System.out.println("折叠手机");
        super.close();
    }

    public void call() {
        System.out.println("折叠手机");
        super.call();
    }

}
