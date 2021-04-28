import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        CoinChange2 sol = new CoinChange2();
        int[] coins;
        int amount;
        int res;

        coins = new int[]{1,2,5};
        amount = 5;
        res = sol.change(amount, coins);
        System.out.println("Coins  : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);
        System.out.println("Result : " + res);
    }   
}
