import java.util.Arrays;

public class NumSquares {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;
    
        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
          square_nums[i] = i * i;
        }
    
        for (int i = 1; i <= n; ++i) {
          for (int s = 1; s < max_square_index; ++s) {
            if (i < square_nums[s])
              break;
            dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
          }
        }
        return dp[n];
      }    
      public static void main(String[] args) {
          NumSquares sol = new NumSquares();
          int n;
          int res;

          n = 12;
          res = sol.numSquares(n);
          System.out.println("Input  : " + n);
          System.out.println("Output : " + res);

          n = 13;
          res = sol.numSquares(n);
          System.out.println("Input  : " + n);
          System.out.println("Output : " + res);
      }
}
