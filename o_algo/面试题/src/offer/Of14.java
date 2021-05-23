package offer;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 动态规划
 */
public class Of14 {

    // 不要求取模
    public int cuttingRope_(int n) {
        int[] dp = new int[n + 1];

        if (n <= 3) return n - 1;

        // 虚假的dp，因为1，2，3的长度，分割后反而更小
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {

            for (int j = 1; j <= i / 2; j++) {

                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);

            }

        }

        return dp[n];
    }

    // 要求取模
    public int cuttingRope(int n) {
        return n > 3 ? (int) h(n) : n - 1;
    }

    public long h(long n) {
        return n > 4 ? (h(n - 3) * 3) % 1000000007 : n;
    }


}
