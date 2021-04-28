import java.util.Arrays;
import java.util.HashMap;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > (); // rem, index
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;                
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) { // for case [0], k == 1
                    return true;                    
                }
            } else {
                map.put(sum, i);                
            }
        }
        return false;
    }   
    public static void main(String[] args) {
        CheckSubarraySum sol = new CheckSubarraySum();
        int[] nums;
        int k;
        boolean res;

        nums = new int[]{23,2,4,6,7};
        k = 6;
        res = sol.checkSubarraySum(nums, k);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("k      : " + k);
        System.out.println("Output : " + res);

        nums = new int[]{23,2,6,4,7};
        k = 6;
        res = sol.checkSubarraySum(nums, k);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("k      : " + k);
        System.out.println("Output : " + res);

        nums = new int[]{23,2,6,4,7};
        k = 13;
        res = sol.checkSubarraySum(nums, k);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("k      : " + k);
        System.out.println("Output : " + res);
    } 
}
