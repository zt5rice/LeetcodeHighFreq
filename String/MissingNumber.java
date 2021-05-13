import java.util.Arrays;

import jdk.incubator.jpackage.main.Main;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return len * (1 + len) / 2 - sum;
    }
    
    public static void main(String[] args) {
        MissingNumber sol = new MissingNumber();
        int[] nums;
        int res;

        nums = new int[]{9,6,4,2,3,5,7,0,1};
        res = sol.missingNumber(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
