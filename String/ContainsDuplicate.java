import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> count = new HashSet<>();
        for (int x : nums) {
            if (count.contains(x)) {
                return true;
            }
            count.add(x);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        int[] nums;
        boolean res;

        nums = new int[]{1,2,3,1};
        res = sol.containsDuplicate(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
