public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
		//stores the remainders
        int m[]=new int[k];
        int sum=0;
        int count=0;
        m[0]=1;
        for(int x: nums){
            sum+=x;
            int rem=sum%k;
            if(rem<0) rem+=k;
            count+=m[rem];
            m[rem]++;
        }
        return count;
    }
}
/*abstract

974. Subarray Sums Divisible by K
Medium

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0

https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/1474834/C%2B%2B-or-faster-than-80.59-or-Easy-to-understand
*/