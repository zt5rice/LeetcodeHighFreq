import java.util.Arrays;

public class MaxProfit2 {
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        MaxProfit2 sol = new MaxProfit2();
        int[] prices;
        int maxProf;

        prices = new int[]{7,1,5,3,6,4};
        maxProf = sol.maxProfit2(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   :" + maxProf);

        prices = new int[]{1,2,3,4,5};
        maxProf = sol.maxProfit2(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   :" + maxProf);

        prices = new int[]{7,6,4,3,1};
        maxProf = sol.maxProfit2(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   :" + maxProf);       
    }    
}
