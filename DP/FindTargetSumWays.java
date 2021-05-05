import java.util.Arrays;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
    public static void main(String[] args) {
        FindTargetSumWays sol = new FindTargetSumWays();
        int[] nums;
        int S, res;

        nums = new int[]{1,1,1,1,1};
        S = 3;
        res = sol.findTargetSumWays(nums, S);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Target = " + S);
        System.out.println("Output : " + res);
        
        nums = new int[]{1};
        S = 1;
        res = sol.findTargetSumWays(nums, S);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Target = " + S);
        System.out.println("Output : " + res);
    }    
}
