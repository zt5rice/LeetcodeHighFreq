import java.util.Arrays;

import jdk.incubator.jpackage.main.Main;

class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProf = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProf) {
                maxProf = prices[i] - minPrice;
            }
        }
        return maxProf;
    }
    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        int[] prices;
        int maxProf;

        prices = new int[]{7,1,5,3,6,4};
        maxProf = sol.maxProfit(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   :" + maxProf);

        prices = new int[]{7,6,4,3,1};
        maxProf = sol.maxProfit(prices);
        System.out.println("Stock Prices : " + Arrays.toString(prices));
        System.out.println("Max Profit   :" + maxProf);
    }    
}