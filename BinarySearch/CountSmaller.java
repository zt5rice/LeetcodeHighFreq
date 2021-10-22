public class CountSmaller {
    public List<Integer> countSmaller(int[] nums){
        int[] res = new int[nums.length];
        int[] pos = new int[nums.length];
        getPos(pos); // 
        int[] helper = new int[nums.length];//an array which is a copy of the entire pos each time after pos’s left and right section have been sorted during the merge sort process
        mergeSort(pos, res, helper, nums, 0, nums.length - 1);
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : res)
        {
            intList.add(i);
        }
                return intList;
        }
        //merge sort pos array 
        public void mergeSort(int[] pos, int[] res, int[] helper, int[] nums, int left, int right){
        //base case
        if (right <= left){
        return;
        }
        
        int mid = left + (right - left)/2;
        mergeSort(pos, res, helper, nums, left, mid);
        mergeSort(pos, res, helper, nums, mid + 1, right);
        
        for (int i = left; i <= right; i++){
        helper[i] = pos[i];
        }
        
        //two pointers to sort left and right side
        int i = left;
        int j = mid + 1;
        int k = left;;//pos[k] is being processed
        
        while (i <= mid){
        //case1: nums[helper[i]] <= nums[helper[j]]: copy helper[i] to pos and update res; move i
        //when j > right, just copy helper[i] to pos and update res
        if (j > right  || nums[helper[i]] <= nums[helper[j]]){
        res[helper[i]] += j - mid - 1;
        pos[k++] = helper[i++];
        }
        else {
        pos[k++] = helper[j++];
        }
        }
        }
        public void getPos(int[] pos){
        for (int i = 0; i <= pos.length - 1; i++){
        pos[i] = i;
        }
        }    
}
