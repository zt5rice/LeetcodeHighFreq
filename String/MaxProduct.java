import java.util.Arrays;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int tmp_max = Math.max(cur, Math.max(min * cur, max * cur));
            min = Math.min(cur, Math.min(min * cur, max * cur));
            max = tmp_max;
            result = Math.max(max, result);
        }
        return result;
    }
    public static void main(String[] args) {
        MaxProduct sol = new MaxProduct();
        int[] nums;
        int res;

        nums = new int[]{2,3,-2,4};
        res = sol.maxProduct(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);

        nums = new int[]{-2,0,-1};
        res = sol.maxProduct(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }    
}
