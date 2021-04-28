import java.util.Arrays;

public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
    public static void main(String[] args) {
        MaxProfit4 sol = new MaxProfit4();
        int k;
        int[] prices;
        int maxProf;

        k = 2;
        prices = new int[]{2,4,1};
        maxProf = sol.maxProfit(k, prices);
        System.out.println("k   =   " + k);
        System.out.println("Prices :" + Arrays.toString(prices));
        System.out.println("Max Profit : " + maxProf);
        k = 2;
        prices = new int[]{3,2,6,5,0,3};
        maxProf = sol.maxProfit(k, prices);
        System.out.println("k   =   " + k);
        System.out.println("Prices :" + Arrays.toString(prices));
        System.out.println("Max Profit : " + maxProf);
    }
}
/*abstract
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 * Ref : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
 */