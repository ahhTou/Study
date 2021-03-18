package com.tou.utils;

import java.util.Random;

public class SaltUtils {

    /**
     * @param n 盐的位数
     * @return 返回随机盐
     */
    public static String getSalt(int n) {
        char[] chars = "ahhTou?_Yes!_AHH_TOU?_NO!".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(4));
    }

}
