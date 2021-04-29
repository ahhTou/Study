package com.tou.s03_prototype;

public class ProClient {
    public static void main(String[] args) {
        ProSheep proSheep1 = new ProSheep("Tom", 1, "白色");
        ProSheep proSheep2 = proSheep1.clone();
        ProSheep proSheep3 = proSheep1.clone();
        ProSheep proSheep4 = proSheep1.clone();
        ProSheep proSheep5 = proSheep1.clone();

        System.out.println(proSheep1);
        System.out.println(proSheep2);
        System.out.println(proSheep3);
        System.out.println(proSheep4);
        System.out.println(proSheep5);
    }
}
