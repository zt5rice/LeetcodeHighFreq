import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// faster than 31.27%
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                dfs(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        int[] candidates;
        int target;
        List<List<Integer>> res;

        candidates = new int[]{2,3,6,7}; 
        target = 7;
        res = sol.combinationSum(candidates, target);
        System.out.println("Input  : " + Arrays.toString(candidates));
        System.out.println("target : " + target);
        System.out.println("Result : " + Arrays.toString(res.toArray()));

        candidates = new int[]{2,3,5}; 
        target = 8;
        res = sol.combinationSum(candidates, target);
        System.out.println("Input  : " + Arrays.toString(candidates));
        System.out.println("target : " + target);
        System.out.println("Result : " + Arrays.toString(res.toArray()));
    }
}
