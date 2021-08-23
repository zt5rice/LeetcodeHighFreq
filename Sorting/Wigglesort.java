import java.util.Arrays;

public class Wigglesort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int median = getMedian(nums);
 
        int higher = 0, lower = nums.length - 1, current = 0;
        while (current <= lower) {
            if (nums[reIndex(current, nums.length)] == median) {
                current++;
            }
 
            else if (nums[reIndex(current, nums.length)] < median) {
                swap(nums, reIndex(current, nums.length), reIndex(lower--, nums.length));
            }
            else swap(nums, reIndex(current++, nums.length), reIndex(higher++, nums.length));
        }
    }
    
    private int reIndex(int index, int n) {
        return (2*index + 1) % (n | 1);
    }
 
    private int getMedian(int[] nums) {
        int start = 0, end = nums.length - 1, target = nums.length / 2;
        while (true) {
            swap(nums, start, (start + end) / 2);
            int swapIndex = start, current = start + 1;
            while (current <= end) {
                if (nums[current] >= nums[start]) swap(nums, ++swapIndex, current);
                current++;
            }
            swap(nums, start, swapIndex);
            if (swapIndex - start == target) return nums[swapIndex];
            else if (swapIndex - start > target) end = swapIndex - 1;
            else {
                target -= (swapIndex - start + 1);
                start = swapIndex + 1;
            }
        }
    }
 
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Wigglesort sol = new Wigglesort();
        int[] nums;

        nums = new int[]{1,5,1,1,6,4};
        System.out.println("Input  : " + Arrays.toString(nums));
        sol.wiggleSort(nums);
        System.out.println("Output : " + Arrays.toString(nums));
    }
}

/*abstract

324. Wiggle Sort II
Medium

Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.
 

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?

*/