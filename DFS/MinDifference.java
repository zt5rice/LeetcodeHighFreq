/*
263. Two Subsets With Min Difference
Medium
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:
34
{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
*/
import java.util.*;

public class MinDifference {
    public static void main(String[] args) {
        MinDifference sol = new MinDifference();
        int[] arr = {1,1,1,1,4};
        System.out.println(sol.minDifference(arr));
    }
    public int minDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.abs(arr[1] - arr[0]);
        }
        // 1. get the sum
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        int[] glbMinDif = {Integer.MAX_VALUE};
        int curSum = 0;
        helper(arr, 0, curSum, glbMinDif, sum);
        return glbMinDif[0];
    }
    private void helper(int[] arr, int index, int curSum, int[] glbMinDif, int sum) {
        // base case
        if (index == arr.length) {
            return;
        } else if (curSum == sum / 2) {
            return;
        }
        // 1. not add
        helper(arr, index + 1, curSum, glbMinDif, sum);
        // 2. add
        curSum += arr[index];
        glbMinDif[0] = Math.min(glbMinDif[0], Math.abs(2*curSum - sum));
        helper(arr, index + 1, curSum, glbMinDif, sum);
        curSum -= arr[index];
    }
}
/*
method: dfs
recurr tree: add or not add

termination cond
    1) minDif == 0
    2) level = arr.length;
TC: o(2^n), sc: o(n)

*/