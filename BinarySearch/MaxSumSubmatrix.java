import java.util.TreeSet;

public class MaxSumSubmatrix {
    
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int ans = Integer.MIN_VALUE;
            for (int r1 = 0; r1 < m; ++r1) {
                int[] arr = new int[n]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])
                for (int r2 = r1; r2 < m; ++r2) {
                    for (int c = 0; c < n; ++c) arr[c] += matrix[r2][c];
                    ans = Math.max(ans, maxSumSubArray(arr, n, k));
                }
            }
            return ans;
        }
        int maxSumSubArray(int[] arr, int n, int k) { // O(N * logN)
            TreeSet<Integer> bst = new TreeSet<>();
            bst.add(0);
            int ans = Integer.MIN_VALUE;
            for (int i = 0, right = 0; i < n; ++i) {
                right += arr[i];
                Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k
                if (left != null) {
                    ans = Math.max(ans, right - left);
                }
                bst.add(right);
            }
            return ans;
        }
    

}
    /*
    Time: O(M^2 * N * logN), where M <= 100 is number of rows, N <= 100 is number of columns in the matrix.
    Space: O(N)    
    363. Max Sum of Rectangle No Larger Than K
Hard

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

 

Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3
    */