import java.util.Arrays;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }
    public static void main(String[] args) {
        LongestConsecutive sol = new LongestConsecutive();
        int[] nums;
        int res;

        nums = new int[]{100,4,200,1,3,2};
        System.out.println("Input  : " + Arrays.toString(nums));
        res = sol.longestConsecutive(nums);
        System.out.println("Output : " + res);

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println("Input  : " + Arrays.toString(nums));
        res = sol.longestConsecutive(nums);
        System.out.println("Output : " + res);
    }
}
