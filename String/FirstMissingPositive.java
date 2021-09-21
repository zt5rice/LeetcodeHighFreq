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
/*abstract

380. Insert Delete GetRandom O(1)
Medium

4106

235

Add to List

Share
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
*/