package leetcode;
class Superpow {
    public int superpow(int a, int[] b) {
        return 0;
    }

    public long modularpow(long a, long n, int mod) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= a % mod;
            }
            a = (a % mod) * (a % mod);
            n >>= 1;
        }
        return ans;
    }

    private long pow(long num, long n, long mod) {
        if (n == 0)
            return 1;
        if (n == 1)
            return num % mod;

        long tempResult = pow(num % mod, n / 2, mod) % mod;

        if (n % 2 == 1)
            return (num % mod) * tempResult * tempResult;
        else
            return tempResult * tempResult;
    }

    public static void main(String[] args) {
        Superpow p = new Superpow();
        System.out.println(p.modularpow(4, 500, 1337));
        System.out.println(p.pow(4, 500, 1337));
    }
}