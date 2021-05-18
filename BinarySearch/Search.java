import java.util.Arrays;

public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }   
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Search sol = new Search();
        int[] nums; 
        int target, res;

        nums = new int[]{4,5,6,7,0,1,2};
        target = 0;
        res = sol.search(nums, target);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Target : " + target);
        System.out.println("Result : " + res);
    }
}
/*abstract
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/