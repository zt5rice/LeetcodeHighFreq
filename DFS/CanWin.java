import java.util.Arrays;

/*
Can I Win
Medium
There is an array of positive integers, in which each integer represents a piece of Pizza’s size, you and your friend take turns to pick pizza from either end of the array.  The winner is the one who gets larger total sum of all pizza. Return whether you will win the game if you start first.

Example:

Input: [2,1,100,3]

Output: True

Explanation: To win the game, you pick 2 first, then your friend will pick either 1 or 3, after that you could pick 100. In the end you could get 2 + 100 = 102, while your friend could only get 1 + 3 = 4.

[[18,74,89,72,90,84,63,8,2,20,99,88,5]]
Expected: [true]
*/

public class CanWin {
    public boolean canWin(int[] array) {
        int[][] dp = new int[array.length][array.length];
        for (int j = 0; j <= array.length - 1; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = array[i];
                } else if (i + 1 == j) {
                    dp[i][j] = Math.max(array[i], array[j]);
                } else {
                    int case1 = array[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int case2 = array[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        int sum = 0;
        for (int e : array) {
            sum += e;
        }

        return dp[0][array.length - 1] > sum - dp[0][array.length - 1];

    }

    public static void main(String[] args) {
        CanWin sol = new CanWin();
        int[] nums = { 50,61,7,98,76,5,6,22,2,82,21,58,45,95,89,48,68 };
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Result : " + sol.canWin(nums));
    }
}
