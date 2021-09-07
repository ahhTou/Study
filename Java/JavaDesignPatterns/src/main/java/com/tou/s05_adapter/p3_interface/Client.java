package com.tou.s05_adapter.p3_interface;

public class Client {
    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            @Override
            public void a() {
                System.out.println("hello");
            }
        };

        adapter.a();
    }
}
