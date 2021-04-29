package com.tou.s03_prototype;

public class Client {
    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("Tom", 1, "白色");

        Sheep sheep2 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        Sheep sheep3 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        Sheep sheep4 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());


        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);

    }
}
