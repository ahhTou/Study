package offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 快速幂
 */
public class Of16 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
            System.out.println(x);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Of16().myPow(10, 4));
        System.out.println("==================");
        System.out.println(new Of16().myPow(10, 5));

    }
}
