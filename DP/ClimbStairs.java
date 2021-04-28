public class ClimbStairs {
    public int climbStairs(int n) { // tc: o(n); sc: o(n)
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) { // tc: o(n); sc: o(1)
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int pp = 1;
        int p = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pp + p;
            pp = p;
            p = cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        ClimbStairs sol = new ClimbStairs();
        int n;
        int res;

        n = 2;
        res = sol.climbStairs(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + res);

        n = 3;
        res = sol.climbStairs(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + res);
    }    
}
