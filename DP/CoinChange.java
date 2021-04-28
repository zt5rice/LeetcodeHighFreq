import java.util.Arrays;

import jdk.incubator.jpackage.main.Main;

public class CoinChange {
    public int coinChange(int[] coins, int amount) { // assume coins sorted decreasing amount
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { // o(n*(m+n))
            dp[i] = amount+1;
            for (int k = coins.length - 1; k >= 0; k--) {
                if (coins[k] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[k]]+1);                
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
      }
      public static void main(String[] args) {
          CoinChange sol = new CoinChange();
          int[] coins;
          int amount;
          int res;

          coins = new int[]{1,2,5};
          amount = 11;
          res = sol.coinChange(coins, amount);
          System.out.println("Coins  : " + Arrays.toString(coins));
          System.out.println("Amount : " + amount);
          System.out.println("Result : " + res);
          
      }
}
