import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = sol.twoSum(nums, target);
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(res));       
    }
}
