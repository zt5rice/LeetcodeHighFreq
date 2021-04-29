import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] nums;
        int res;

        nums = new int[]{1,1,2};
        res = sol.removeDuplicates(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        res = sol.removeDuplicates(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }    
}
