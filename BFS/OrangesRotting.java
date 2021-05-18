import java.util.Arrays;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int r = grid.length; 
        int c = grid[0].length; 
        int timestamp = 2;
        while (dfs(timestamp, grid, r, c)) {
            timestamp++;
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return timestamp - 2;
    }
    
    private boolean dfs(int timestamp, int[][] grid, int r, int c) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean TBC = false; // to be continued;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]  == timestamp) {
                    for (int[] d : dir) {
                        int cRow = i + d[0];
                        int cCol = j + d[1];
                        if (cRow >= 0 && cRow < r && cCol >= 0 && cCol < c) {
                            if (grid[cRow][cCol] == 1) {
                                grid[cRow][cCol] = timestamp + 1;
                                TBC = true;
                            }
                        }
                    }
                }
            }
        }
        return TBC;
    }

    public static void main(String[] args) {
        OrangesRotting sol = new OrangesRotting();
        int[][] grid;
        int res;

        grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        res = sol.orangesRotting(grid);
        System.out.println("Input  : " + Arrays.deepToString(grid));
        System.out.println("Output : " + res);
    }
}
