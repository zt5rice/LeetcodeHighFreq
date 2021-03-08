/*
96. Unique Binary Search Trees
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
*/

import java.util.*;
public class NumTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1]*dp[i-j];
        }
        }
        return dp[n];
    }
    public int numTrees2(int n) {
        // check the Catalan number, use formula of Catalan number
        long C = 1;
        for (int i = 0; i < n; ++i) {
          C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
      }
    public static void main(String[] args) {
        // TC: o(N^2)
        NumTrees sol = new NumTrees();
        int[] test = {1, 2, 3, 4, 5};
        int[] res = new int[test.length];
        int i = 0;
        for (int n : test) {
            res[i++] = sol.numTrees(n);
        }
        System.out.println("Input  : " + Arrays.toString(test));
        System.out.println("Output : " + Arrays.toString(res));
    }
}
