import java.util.Arrays;

public class Jump2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
        Jump2 sol = new Jump2();
        int[] nums;
        int res;

        nums = new int[]{2,3,1,1,4};
        res = sol.jump(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
