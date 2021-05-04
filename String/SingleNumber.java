import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int rst = 0;
        for (int i : nums) {
            rst ^= i;
        }
        return rst;
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
        int[] nums;
        int res;

        nums = new int[]{2,2,1};
        res = sol.singleNumber(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }    
}
