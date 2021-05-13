import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();
        int[] nums;
        int res;

        nums = new int[]{2,2,1,1,1,2,2};
        res = sol.majorityElement(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/majority-element/


*/