import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;

        if (n == 0) {
            ArrayList<String> res = new ArrayList<String>();
            String str = formatRange(lower, upper);
            res.add(str);
            return res;
        }
       List<String> missingRanges = new ArrayList<>();
        if (nums[0] > lower) {
            missingRanges.add(formatRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper) {
            missingRanges.add(formatRange(nums[n - 1] + 1, upper));
        }

        return missingRanges;        
    }
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
    public static void main(String[] args) {
        FindMissingRanges sol = new FindMissingRanges();
        int lower, upper;
        List<String> res;
        int[] nums;

        lower = 0;
        upper = 99;
        nums = new int[]{0,1,3,50,75};

        res = sol.findMissingRanges(nums, lower, upper);
        System.out.println("Input range : " + lower + ',' + upper );
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }    
}
