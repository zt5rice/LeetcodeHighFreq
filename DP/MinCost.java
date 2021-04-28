import java.util.Arrays;

public class MinCost {
    public int minCost(int[][] costs) {
        for (int n = costs.length - 2; n >= 0; n--) {
            // Total cost of painting the nth house red.
            costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
            // Total cost of painting the nth house green.
            costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
            // Total cost of painting the nth house blue.
            costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
        }

        if (costs.length == 0) return 0;   

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
    public static void main(String[] args) {
        MinCost sol = new MinCost();
        int[][] costs;
        int res;

        costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        res = sol.minCost(costs);
        System.out.println("Input : " + Arrays.deepToString(costs));
        System.out.println("Output: " + res);

        costs = new int[][]{{7,6,2}};
        res = sol.minCost(costs);
        System.out.println("Input : " + Arrays.deepToString(costs));
        System.out.println("Output: " + res);
    }
}
