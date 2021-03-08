/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

*/
import java.util.*;
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // linear scan from right to left and find the first cliff position
        int pos = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // find the smallest element greater than a[pos] in a[pos + 1.. size - 1]
            int ind = binarySearch(nums, nums[pos], pos + 1, nums.length - 1);
            // swap
            swap(nums, ind, pos);
            // reverse
            reverse(nums, pos + 1, nums.length - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // find the smallest element greater than target in nums and return the index
    public int binarySearch(int[] nums, int target, int left, int right) {
        int res = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] test = {1,2,3};
        System.out.println("Input  : " + Arrays.toString(test));        
        sol.nextPermutation(test);
        System.out.println("Output : " + Arrays.toString(test));   
        test = new int[]{3,2,1};
        System.out.println("Input  : " + Arrays.toString(test));        
        sol.nextPermutation(test);
        System.out.println("Output : " + Arrays.toString(test));     
    }
}
