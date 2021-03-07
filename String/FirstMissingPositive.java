import java.util.*; // find the 
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive sol = new FirstMissingPositive();
        int[] num1 = {3,4,-1,1};
        System.out.println(sol.firstMissingPositive(num1));
    }
    /*
    Method 1: brutal force
    1. Put all element to hashset
    2. check from 1, whether the positive number exists in hashset
    TC: o(n) - n is the size of the nums arrya
    SC: o(n) - 
    */
    public int smallestPositive0(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int e : nums){
            set.add(e);
        }
        int i = 1;
        while (!set.contains(i)){// 1 2 3 4 5
            i++;
        }
        return i;
    }
    /*
    Method 2: Inspired by brutal force. Try to achieve hashset with inplace nums
    in the while loop, check 1, 2, 3, ..., n in the hashset
    hence swap nums[i] (at index i) with nums[nums[i] - 1] (at index nums[i] - 1), to restore 1, 2, ..., n

    use another loop to check num[i] != i + 1, if so that means (i + 1) doens't exist
    */
    public int firstMissingPositive(int[] nums) {
        // conv to 1, …., n
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > len) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        int j = 0;
        while (j < len && nums[j] == j + 1) {
             j++;
        }
        return j + 1;
    }
    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }  


        
}
