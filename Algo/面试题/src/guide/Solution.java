package guide;


import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    /**
     * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     */
    public String replaceSpace(String[] strs) {

        // 如果有空串 直接返回 ”“
        for (String str : strs) {
            if (strs.length <= 1 || str == null || str.length() == 0) return "";
        }

        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);

        int num = Math.min(strs[0].length(), strs[len - 1].length());
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;

        }
        return res.toString();
    }

    /**
     * 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。\
     * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
     */
    public int longestPalindrome(String s) {
        if (s.length() <= 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int even = 0; // 偶数数量

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                even++;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.isEmpty() ? even * 2 : even * 2 + 1;
    }

    /**
     * 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，
     * 可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        char[] chars = s.toLowerCase().toCharArray();

        int len = s.length();
        int j = s.length() - 1;

        for (int i = 0; ; i++, j--) {
            while (i < len - 1 && !Character.isLetterOrDigit(chars[i])) i++;

            while (j > 0 && !Character.isLetterOrDigit(chars[j])) j--;

            if (i >= j) return true;

            if (chars[i] != chars[j]) return false;
        }


    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */
    public String longestSonPalindromeDC(String s) {
        if (s.length() == 1) return s;

        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > 0; j--) {
                if (i > j) break;
                if (longestSonPalindromeHelper(chars, i, j)) {
                    if (j - i + 1 > res.length()) res =
                            new StringBuilder(String.valueOf(chars).substring(i, j + 1));
                }
            }
        }

        return res.toString();
    }


    public String longestSonPalindrome(String s) {
        return null;
    }

    public static boolean longestSonPalindromeHelper(char[] chars, int start, int end) {
        for (int i = start, j = end; j >= 0 && i < j && i < end; j--, i++) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }


}
