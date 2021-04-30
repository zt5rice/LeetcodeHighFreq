import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int cur = nums[left] + nums[right];            
            if (cur < -nums[i]) {
                left++;
            } else if (cur > -nums[i]) {
                right--;
            } else {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }    
            }
        }
    }
    
    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] nums;
        List<List<Integer>> res;

        nums = new int[]{-1,0,1,2,-1,-4};
        res = sol.threeSum(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Result : " + Arrays.toString(res.toArray()));
        
        nums = new int[]{};
        res = sol.threeSum(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Result : " + Arrays.toString(res.toArray()));
        
        nums = new int[]{0};
        res = sol.threeSum(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Result : " + Arrays.toString(res.toArray()));
    }
}
