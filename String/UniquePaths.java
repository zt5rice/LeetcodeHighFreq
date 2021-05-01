public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0;  j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];                    
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();
        int m, n, res;

        m = 3;
        n = 7;
        res = sol.uniquePaths(m, n);
        System.out.println("[ m,  n ] : " + m + " , " + n);
        System.out.println("Output    : " + res);

        m = 3;
        n = 2;
        res = sol.uniquePaths(m, n);
        System.out.println("[ m,  n ] : " + m + " , " + n);
        System.out.println("Output    : " + res);

        m = 7;
        n = 3;
        res = sol.uniquePaths(m, n);
        System.out.println("[ m,  n ] : " + m + " , " + n);
        System.out.println("Output    : " + res);

        m = 3;
        n = 3;
        res = sol.uniquePaths(m, n);
        System.out.println("[ m,  n ] : " + m + " , " + n);
        System.out.println("Output    : " + res);
    }
}
