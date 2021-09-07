package com.tou.s08_composite;

public class Client {
    public static void main(String[] args) {
        // 创建 学校
        University university = new University("清华大学", "中国顶级大学");

        // 创建 学院
        Collage collage1 = new Collage("计算机学院", "学计算机的学院");
        Collage collage2 = new Collage("信息工程学院学院", "啥啥啥的学院");

        // 创建各学院下面的系
        collage1.add(new Department("软件开发", "搞软件的"));
        collage1.add(new Department("网络攻防", "搞安全的"));

        collage2.add(new Department("A", "A_DESC"));
        collage2.add(new Department("B", "B_DESC"));

        university.add(collage1);
        university.add(collage2);

        university.print();

    }
}
