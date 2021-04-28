import java.util.Arrays;

public class MaxProfit5 {
    public int maxProfit5(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
          int preSold = sold;
    
          sold = held + price;
          held = Math.max(held, reset - price);
          reset = Math.max(reset, preSold);
        }
    
        return Math.max(sold, reset);
      }        
    
    public static void main(String[] args) {
        MaxProfit5 sol = new MaxProfit5();
        int[] prices;
        int maxProf;

        prices = new int[]{1,2,3,0,2};
        maxProf = sol.maxProfit5(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   : " + maxProf);

        prices = new int[]{1};
        maxProf = sol.maxProfit5(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   : " + maxProf);
    }
}
/*abstract
309. Best Time to Buy and Sell Stock with Cooldown
Medium

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

According to the state machine we defined before, we can then deduce the formulas to calculate the values for the state arrays, as follows:

\text{sold}[i] = \text{hold}[i-1] + \text{price}[i] \\ \text{held}[i] = \max{(\text{held}[i-1], \quad \text{reset}[i-1] - \text{price}[i])} \\ \text{reset}[i] = \max{(\text{reset}[i-1], \quad \text{sold}[i-1])}sold[i]=hold[i−1]+price[i]
held[i]=max(held[i−1],reset[i−1]−price[i])
reset[i]=max(reset[i−1],sold[i−1])

Here is how we interpret each formulas:

\text{sold}[i]sold[i]: the previous state of sold can only be held. Therefore, the maximal profits of this state is the maximal profits of the previous state plus the revenue by selling the stock at the current price.

\text{held}[i]held[i]: the previous state of held could also be held, i.e. one does no transaction. Or its previous state could be reset, from which state, one can acquire a stock at the current price point.

\text{reset}[i]reset[i]: the previous state of reset could either be reset or sold. Both transitions do not involve any transaction with the stock.
*/