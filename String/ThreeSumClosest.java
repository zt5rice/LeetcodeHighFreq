import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
        }
        return target - diff;
    }    
    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] nums;
        int target, res;

        nums = new int[]{-1,2,1,-4};
        target = 1;
        res = sol.threeSumClosest(nums, target);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Result : " + res);
    }   
}
