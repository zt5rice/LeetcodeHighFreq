/*
221. Maximal Square
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

The given matrix is not null and guaranteed to be of size N * N, N >= 0
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2


c: input - int[], output - n
method: 2d dp

dp[i][j] - largest size of square ending with matrix[i][j]
  0 1 2 3
0 0 0 0 0
1 1 1 1 1
2 0 1 2
3 
recur rule: dp[i][j] = 0, if matr[i][j] == 0
                    = Math.min(3 left upper adj elem) + 1  , if matr[i][j] == 1
record glbmax
return glbmax
tc/sc: o(n^2)

*/
import java.util.Arrays;

public class Largest {
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return 0;
        }
        int glbmax = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1]; // max length of matrix with first row row and col col
        for (int i = 1; i < row + 1; i++) {
          for (int j = 1; j < col + 1; j++) {
            if (matrix[i-1][j-1] == 0) {
              dp[i][j] = 0;
            } else {
              dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
              dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
            }
            glbmax = Math.max(glbmax, dp[i][j]);
          } 
        } 
        System.out.println("dp matrix : ");
        System.out.println(Arrays.deepToString(dp));
        return glbmax;
      }
      public static void main(String[] args) {
          Largest sol = new Largest();
          int[][] matrix = {{1,0,0},{0,0,0},{0,0,0}};
          System.out.println("Input : ");
          System.out.println(Arrays.deepToString(matrix));
          int rst = sol.largest(matrix);
          System.out.println(rst);
      }
}
