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

    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
        }  // tc: o(m+n), sc:o(1) http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
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
    44. Wildcard Matching
Hard

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).    */