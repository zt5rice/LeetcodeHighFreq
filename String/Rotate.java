import java.util.Arrays;

public class Rotate {
    // Method - 1, TC/SC: o(N2)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    // best vesion by Yan, Method - 2, TC: o(N2), SC: O(1)
    public void rotateBest(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++) {
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[n - 1 - i][left];
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 - left] = tmp;
            }
        }
    }
    // end of method 2

    // Method 3 - format method 1 by Yan
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
          return;
        }
        mirrorY(matrix, n);
        mirrorYEX(matrix, n);
      }
      // mirror hte point by y axis;
      private void mirrorY(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n / 2; j++) {
            swap(matrix, i, j, i, n - 1 - j);
          } 
        }
      }
     // mirror the oint by the line y = x
      private void mirrorYEX(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j + i < n - 1; j++) {
            swap(matrix, i, j, n - 1 - j, n - 1 - i);
          }
        }
      }
    
      private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
        int tmp = matrix[iRow][iCol];
        matrix[iRow][iCol] = matrix[jRow][jCol];
        matrix[jRow][jCol] = tmp;
      }
    // end of method 3
    public static void main(String[] args) {
        Rotate sol = new Rotate();
        int[][] matrix;

        matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Input  : " + Arrays.deepToString(matrix));
        sol.rotate(matrix);
        System.out.println("Output : " + Arrays.deepToString(matrix));
        sol.rotateBest(matrix);
        System.out.println("Output : " + Arrays.deepToString(matrix));
        sol.rotate3(matrix);
        System.out.println("Output : " + Arrays.deepToString(matrix));
    }
}
