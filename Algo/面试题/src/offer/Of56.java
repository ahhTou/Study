package offer;

import java.util.Arrays;

/*
 *  数组中数字出现的次数
 * */
public class Of56 {

    // 除了 某位
    public int singleNumbers(int[] nums) {
        int res = 0;
        int[] k = new int[32];

        for (int num : nums)
            for (int i = 0; i < 32; i++)
                k[i] += (num >> i & 1); //当前位数为 1 时 + 1

        for (int i = 0; i < 32; i++) {
            res |= (k[i] % 3) << i;
        }


        return res;
    }

    // 除了 某两位出现单次， 其他出现两次
    public int[] _singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;

        for (int num : nums)  // 遍历异否
            n ^= num;


        while ((n & m) == 0) m <<= 1; // m 位首位就是 区分 x, y 不同的某一位

        for (int num : nums) {
            if ((num & m) != 0) x ^= num; // 如果 m 位 和 num 不同，这分为 x组，相同 分为 y组
            else y ^= num;
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Of56()._singleNumbers(new int[]{4, 1, 3, 4, 5, 3})));
        System.out.println(new Of56().singleNumbers(new int[]{1, 1, 3, 3, 5, 1, 3}));
    }
}
