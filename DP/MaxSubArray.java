import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int glbmx = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur = cur + nums[i];
            }
            glbmx = Math.max(glbmx, cur);
        }
        return glbmx;
    }   
    public static void main(String[] args) {
        MaxSubArray sol = new MaxSubArray();
        int[] nums;
        int res;

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        res = sol.maxSubArray(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);

        nums = new int[]{1};
        res = sol.maxSubArray(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);

        nums = new int[]{5,4,-1,7,8};
        res = sol.maxSubArray(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
/*abstract
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

*/

