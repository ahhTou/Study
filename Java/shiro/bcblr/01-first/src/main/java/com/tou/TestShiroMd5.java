package com.tou;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestShiroMd5 {
    public static void main(String[] args) {

        // 创建一个md5算法
        Md5Hash md5Hash = new Md5Hash("123");

        System.out.println(md5Hash.toHex());

        // 加盐
        Md5Hash md5HashSalt = new Md5Hash("123", "X0**at");

        System.out.println(md5HashSalt.toHex());

        // 使用md5 + salt + hash散列
        Md5Hash md5HashSaltPlus = new Md5Hash("123", "X0**at", 1024);

        System.out.println(md5HashSaltPlus.toHex());



    }
}
