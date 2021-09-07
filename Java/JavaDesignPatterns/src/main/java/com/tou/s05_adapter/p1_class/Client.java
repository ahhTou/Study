package com.tou.s5_adapter.p1_class;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());

    }
}
