import java.util.Arrays;

public class MaxProfit3 {
    public int maxProfit3(int[] prices) {
        int t1Cost = Integer.MAX_VALUE, 
            t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
            t2Profit = 0;
    
        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // reinvest the gained profit in the second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
    
        return t2Profit;
      }
    public static void main(String[] args) {
        MaxProfit3 sol = new MaxProfit3();
        int[] prices;
        int maxProf;

        prices = new int[]{3,3,5,0,0,3,1,4};
        maxProf = sol.maxProfit3(prices);
        System.out.println("Prices :" + Arrays.toString(prices));
        System.out.println("Max Profit : " + maxProf);
       
        prices = new int[]{1,2,3,4,5};
        maxProf = sol.maxProfit3(prices);
        System.out.println("Prices :" + Arrays.toString(prices));
        System.out.println("Max Profit : " + maxProf);

        prices = new int[]{3,3,5,0,0,3,1,4};
        maxProf = sol.maxProfit3(prices);
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