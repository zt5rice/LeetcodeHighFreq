import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) { // inplace dp; tc: o(rc), sc: o(1)
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 &&  j == col - 1) {
                    grid[i][j] += 0;
                } else if (i == row - 1) {
                    grid[i][j] += grid[i][j+1];
                } else if (j == col - 1) {
                    grid[i][j] += grid[i+1][j];
                } else {
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
    public static void main(String[] args) {
        int[][] grid;
        int res;
        MinPathSum sol = new MinPathSum();

        grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Input  : " + Arrays.deepToString(grid));
        res = sol.minPathSum(grid);
        System.out.println("Output : " + res);

        grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println("Input  : " + Arrays.deepToString(grid));
        res = sol.minPathSum(grid);
        System.out.println("Output : " + res);
    }
}
/*abstract
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

*/