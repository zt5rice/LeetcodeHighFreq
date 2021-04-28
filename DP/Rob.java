import java.util.Arrays;

public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length]; // dp[i] - max amount from substring [0, i]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
        Rob sol = new Rob();
        int[] nums;
        int res;

        nums = new int[]{1,2,3,1};
        res = sol.rob(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);

        nums = new int[]{2,7,9,3,1};
        res = sol.rob(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }    
}
