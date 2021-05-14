import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != 0) {
                nums[s++] = nums[f];
            }
        }
        for (int i = s; i < nums.length; i++) {
            nums[i] = 0;
        }
        return;
    }

    public static void main(String[] args) {
        MoveZeroes sol = new MoveZeroes();
        int[] nums;

        nums = new int[]{0,1,0,3,12};
        System.out.println("Input  : " + Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println("Output : " + Arrays.toString(nums));
    }
}
