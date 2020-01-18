class Power {
    public static double myPow(double x, int n) {
        double ans = 1;
        if (x == 1)
            return 1;
        if (n < 0) {
            if ((n & 1) == 1) {
                ans *= (1 / x);
            }
            ans *= (1 / x) * (1 / x);

            n = -(n >> 1);
            x = 1 / x;
        }

        while (n > 0) {
            if (n == 1)
                return ans;
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            ans = ans * x * x;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(1, Integer.MIN_VALUE));
    }
}