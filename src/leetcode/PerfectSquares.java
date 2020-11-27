package leetcode;
/*279. Perfect Squares*/
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(15));
    }

    public int numSquares(int n) {
        if (n <= 3)
            return n;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            /*
            the maximum perfect square which can be added is the number of ones that can be added to form that number.
            Since 1 is lowest minimum square number
            */
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            double x = Math.sqrt(i);
            if (x - Math.floor(x) == 0) {
                //if number itself is a perfect square then answer is 1;
                dp[i] = 1;
            } else {
                for (int j = 1; j * j <= i; j++) {
                    //else check with the help of previous numbers
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                }
            }

        }

        return dp[n];
    }
}

