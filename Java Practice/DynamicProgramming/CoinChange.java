package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    /*
        [1,3,4,5]  7
        Using Bottom Up Dynamic Programming

        dp[0] = 0  coins
        dp[1] = infi
        dp[2] = infi
        dp[3] = infi
        dp[4] = infi
        dp[5] = infi
        dp[6] = infi
        dp[7] = infi

        [1, 3, 4, 5]
         ^
         currAmount = 1
         if(amount - currMount >= 0)
            dp[1] = min(dp[1], 1(coin) + dp[6](minimum coins for 6))
          else
     */


    public static int coinChangeDp(int amount, int[] coins){
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int currAmount = 0 ; currAmount <= amount; currAmount++){
            for(int j = 0 ; j < coins.length; j++){
                if(currAmount - coins[j] >= 0){
                    dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coins[j]]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = {2, 1};
        int amount = 3;
        System.out.println(coinChangeDp(amount, coins));
    }

}
