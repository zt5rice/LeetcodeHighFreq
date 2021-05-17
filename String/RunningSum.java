import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        RunningSum sol = new RunningSum();
        int[] nums, res;

        nums = new int[] { 1, 2, 3, 4 };
        System.out.println("Input  : " + Arrays.toString(nums));
        res = sol.runningSum(nums);
        System.out.println("Output : " + Arrays.toString(res));
    }
}
