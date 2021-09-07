package offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Of20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        boolean dFlag = false, eFlag = false, numFlag = false;

        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];

            if (c >= '0' && c <= '9') numFlag = true;
            else if (c == 'e' || c == 'E') {

                if (!numFlag || eFlag) return false;
                numFlag = false;
                eFlag = true;

            } else if (c == '.') {

                if (dFlag || eFlag) return false;
                dFlag = true;

            } else if (c == '-' || c == '+') {

                // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;

            } else return false; // 其它情况均为不合法字符

        }

        return numFlag;
    }


    public boolean _isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        Integer start = null, end = null;
        int e = 1, d = 1, o = 1, needNum = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            boolean isNumber = (c - '0') >= 0 && (c - '0') <= 9;
            boolean isE = c == 'E' || c == 'e';
            boolean isO = c == '+' || c == '-';
            boolean isDH = c == '.';
            boolean isSpace = c == ' ';


            if (needNum > 0 && isNumber) needNum--;

            // 0. 不能出现特殊符号
            if (!isNumber && !isE && !isO && !isDH && !isSpace) {
                System.out.println("特殊符号 -> " + c);
                return false;
            }

            // 1. 如果end 后面 还有 空格 就返回 false
            if (end != null && !isSpace) {
                System.out.println("end 后 不能有其他字符");
                return false;
            }

            // 2. 出现超出限制的 逗号 或者 运算符 返回 false
            if ((isDH && --d < 0) || (isO && --o < 0)) {
                return false;
            }


            // 3. e 的 情况
            if (start != null && isE) {

                needNum++; // 如果出现e, 后面就要有数字

                if (d > 0) d = 0; // e 后不能出现点

                if (e-- < 0) {
                    System.out.println("出现了两个e");
                    return false;// 如果出现 两个 e 返回 false}
                }

                if (i < s.length() - 1
                        && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')
                        && ++i == s.length()) {
                    System.out.println("e后符号问题");
                    return false; // 如果 e 的下一位是符号， 且下一位是最后一位则返回 false
                }
            }


            // 4. 第一位的问题
            if (!isSpace && start == null) {
                start = i;
                if (isE) end = i; // 如果第一位是e，那么后面只能是空格
                else if (isNumber) o = 0;
                else if (isDH) {
                    needNum++;
                    e = 0;
                    o = 0;
                } else if (c != '+' && c != '-' && (c - '0') < 0 && (c - '0') > 9) {
                    System.out.println("第一位问题" + c);
                    return false;
                }
            }

            // 如果start 出现后 再遇见空格，则 end 为 i - 1
            if (end == null && start != null && c == ' ') end = i - 1;

        }

        return start != null && needNum == 0;
    }

    public static void main(String[] args) {
        Of20 of20 = new Of20();
        System.out.println(of20.isNumber("+100"));
        System.out.println(of20.isNumber("5e2"));
        System.out.println(of20.isNumber("-123"));
        System.out.println(of20.isNumber("3.1416"));
        System.out.println(of20.isNumber("-1E-16"));
        System.out.println(of20.isNumber("0123"));
        System.out.println(of20.isNumber(".1"));
        System.out.println(of20.isNumber(" -1."));
        System.out.println(of20.isNumber(" -.1"));


        System.out.println("=============");

        System.out.println(of20.isNumber("."));
        System.out.println(of20.isNumber("12e"));
        System.out.println(of20.isNumber("1a3.14"));
        System.out.println(of20.isNumber("1.2.3"));
        System.out.println(of20.isNumber("+-5"));
        System.out.println(of20.isNumber("6+1"));
        System.out.println(of20.isNumber(".8+"));
        System.out.println(of20.isNumber(" -."));
    }

}
