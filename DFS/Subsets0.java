import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets0 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curLayer = new ArrayList<>();
        helper(nums, 0, curLayer, res);
        return res;
    }
    private void helper(int[] nums, int index, List<Integer> curLayer, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(curLayer));
            return;
        }
        // 1. not add
        helper(nums, index + 1, curLayer, res);
        // 2. add
        curLayer.add(nums[index]);
        helper(nums, index + 1, curLayer, res);
        curLayer.remove(curLayer.size() - 1);
    }
    public static void main(String[] args) {
        Subsets0 sol = new Subsets0();
        int[] nums;
        List<List<Integer>> res;

        nums = new int[]{1,2,3};
        res = sol.subsets(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(res.toArray()));

        nums = new int[]{0};
        res = sol.subsets(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }
}
