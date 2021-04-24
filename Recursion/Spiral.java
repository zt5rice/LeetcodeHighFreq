import java.util.*;
public class Spiral {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int n = matrix.length;
        int offset = 0;
        helper(matrix, res, offset, n);
        return res;
      }
      private void helper(int[][] matrix, List<Integer> res, int offset, int n) {
        // base case
        if (offset == (n + 1) / 2) { // 4 ==2, 3 ==2
          return;
        }
        int left = offset;
        int right = n - 1 - offset;
        int up = offset;
        int down = n - 1 - offset;
        if (left > right || up > down) {
          return;
        }
        for (int i = left; i <= right; i++) {
          res.add(matrix[up][i]);
        }
        for (int j = up + 1; j < down; j++) {
          res.add(matrix[j][right]);
        }
        for (int k = right; k >= 0; k--) {
          res.add(matrix[down][k]);
        }
        for (int l = down -1; l > 0; l--) {
          res.add(matrix[l][left]);
        }
        helper(matrix, res, offset + 1, n);
      }    
}
