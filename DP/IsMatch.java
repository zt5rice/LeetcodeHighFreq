public class IsMatch {
    public boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // for (int i=1; i<=m; i++) {
        // 	dp[i][0] = false;
        // }
        
        for(int j=1; j<=n; j++) {
            if(p.charAt(j-1)=='*'){
                dp[0][j] = true;
            } else {
                break;
            }
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (p.charAt(j-1)!='*') {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
      }
    /*
    The original post has DP 2d array index from high to low, which is not quite intuitive.
    
    Below is another 2D dp solution. Ideal is identical.
    
    dp[i][j] denotes whether s[0....i-1] matches p[0.....j-1],
    
    First, we need to initialize dp[i][0], i= [1,m]. All the dp[i][0] should be false because p has nothing in it.
    
    Then, initialize dp[0][j], j = [1, n]. In this case, s has nothing, to get dp[0][j] = true, p must be '*', '**', '***',etc. Once p.charAt(j-1) != '*', all the dp[0][j] afterwards will be false.
    
    Then start the typical DP loop.
    
    Though this solution is clear and easy to understand. It is not good enough in the interview. it takes O(mn) time and O(mn) space.
    
    Improvement: 1) optimize 2d dp to 1d dp, this will save space, reduce space complexity to O(N). 2) use iterative 2-pointer.
    */
      public static void main(String[] args) {
          IsMatch sol = new IsMatch();
          String s, p;
          Boolean res;

          s = "adceb";
          p = "*a*b";
          System.out.println("[s, p] : " + s + " , " + p);
          res = sol.isMatch(s, p);
          System.out.println("Output : " + res);
      }
    }
    /*
    The original post has DP 2d array index from high to low, which is not quite intuitive.
    
    Below is another 2D dp solution. Ideal is identical.
    
    dp[i][j] denotes whether s[0....i-1] matches p[0.....j-1],
    
    First, we need to initialize dp[i][0], i= [1,m]. All the dp[i][0] should be false because p has nothing in it.
    
    Then, initialize dp[0][j], j = [1, n]. In this case, s has nothing, to get dp[0][j] = true, p must be '*', '**', '***',etc. Once p.charAt(j-1) != '*', all the dp[0][j] afterwards will be false.
    
    Then start the typical DP loop.
    
    Though this solution is clear and easy to understand. It is not good enough in the interview. it takes O(mn) time and O(mn) space.
    
    Improvement: 1) optimize 2d dp to 1d dp, this will save space, reduce space complexity to O(N). 2) use iterative 2-pointer.
    */