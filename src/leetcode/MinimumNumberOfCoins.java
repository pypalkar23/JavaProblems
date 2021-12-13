package leetcode;

import java.util.Arrays;

public class MinimumNumberOfCoins {
    public static int minimumNumberOfCoins(int coins[], int target){
        int dp[]= new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0]=0;
        int n= coins.length;
        for(int i=1;i<=target;i++){
            for(int j=0;j<n && coins[j]<=i;j++){
                int sub_res = 1 + dp[i-coins[j]];
                if(sub_res != Integer.MAX_VALUE && sub_res < dp[i]){
                    dp[i] = sub_res;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int coins[]= new int[]{1,3,5};
        System.out.println(minimumNumberOfCoins(coins, 12));



    }
}

