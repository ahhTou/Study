package com.tou.s03_prototype.deep_clone;

public class DeepClient {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "大牛类");

        DeepProtoType p1 = p.clone();
        DeepProtoType p2 = p.clone();
        DeepProtoType p3 = p.clone();
        DeepProtoType p4 = p.clone();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        DeepProtoType p12 = p.deepClone();
        DeepProtoType p22 = p.deepClone();
        DeepProtoType p32 = p.deepClone();
        DeepProtoType p42 = p.deepClone();

        System.out.println(p12);
        System.out.println(p22);
        System.out.println(p32);
        System.out.println(p42);

    }

}
