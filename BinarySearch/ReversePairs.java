public class ReversePairs {
   
        int[] helper;
        public int reversePairs(int[] nums) {
            this.helper = new int[nums.length];
            return mergeSort(nums, 0, nums.length-1);
        }
        private int mergeSort(int[] nums, int s, int e){
            if(s>=e) return 0; 
            int mid = s + (e-s)/2; 
            int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
            for(int i = s, j = mid+1; i<=mid; i++){
                while(j<=e && nums[i]/2.0 > nums[j]) j++; 
                cnt += j-(mid+1); 
            }
            //Arrays.sort(nums, s, e+1); 
            myMerge(nums, s, mid, e);
            return cnt; 
        }
        
        private void myMerge(int[] nums, int s, int mid, int e){
            for(int i = s; i<=e; i++) helper[i] = nums[i];
            int p1 = s;//pointer for left part
            int p2 = mid+1;//pointer for rigth part
            int i = s;//pointer for sorted array
            while(p1<=mid || p2<=e){
                if(p1>mid || (p2<=e && helper[p1] >= helper[p2])){
                    nums[i++] = helper[p2++];
                }else{
                    nums[i++] = helper[p1++];
                }
            }
        }
    
    /*
    MergeSort
    
    Explanation: In each round, we divide our array into two parts and sort them. So after "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", the left part and the right part are sorted and now our only job is to count how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
    For example,
    left: 4 6 8 right: 1 2 3
    so we use two pointers to travel left and right parts. For each leftPart[i], if j<=e && nums[i]/2.0 > nums[j], we just continue to move j to the end, to increase rightPart[j], until it is valid. Like in our example, left's 4 can match 1 and 2; left's 6 can match 1, 2, 3, and left's 8 can match 1, 2, 3. So in this particular round, there are 8 pairs found, so we increases our total by 8.
    
    */    
}

/*
493. Reverse Pairs
Hard

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3


*/
