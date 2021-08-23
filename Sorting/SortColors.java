import java.util.*;

public class SortColors {

    /*
     * Dutch National Flag problem solution.
     */
    public int[] sortColors(int[] nums) {
        // for all idx < i : nums[idx < i] = 0
        // j is an index of element under consideration
        int p0 = 0, curr = 0;
        // for all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else
                curr++;
        }
        return nums;
    }

    public static void main(String[] args) {
        SortColors sol = new SortColors();
        int[] nums, res;

        nums = new int[]{2,0,2,1,1,0};
        res = sol.sortColors(nums);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(res));
    }
}
/*abstract

75. Sort Colors
Medium

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

*/