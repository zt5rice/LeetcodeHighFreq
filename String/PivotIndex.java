import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
    
    public static void main(String[] args) {
        PivotIndex sol = new PivotIndex();
        int[] nums;
        int res;

        nums = new int[]{1,7,3,6,5,6};
        res = sol.pivotIndex(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/find-pivot-index/

*/