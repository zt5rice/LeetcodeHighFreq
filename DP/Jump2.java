import java.util.Arrays;

public class Jump2 {
    public int jump(int[] nums) { // Method: DP, TC: O(N2), sc: o(n)
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    public int jump2(int[] nums) { // greedy, TC: O(n), SC: o(1)
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }

    public int jump3(int[] nums) { // variant BFS, tc: o(n), sc: o(1)
        if (nums.length <= 1) return 0;
        int curMax = 0; // to mark the last element in a level
        int level = 0, i = 0;
        while (i <= curMax) { 
            int furthest = curMax; // to mark the last element in the next level
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }

    public int jump5(int[] nums) { // normal BFS, tc: o(n2), sc: o(n)
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int depth = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int index = q.remove();
                if(index==nums.length-1) return depth;
                for(int j=1; j<=nums[index]; j++)
                {
                    int neighbor_index = index + j;
                    //if(neighbor_index==nums.length-1) return depth+1;
                    if(neighbor_index>nums.length-1) break;
                    if(visited[neighbor_index]) continue;
                    q.add(neighbor_index);
                    visited[neighbor_index]=true;
                }
            }
            depth++;
        }
        return -1;   
    }
    public static void main(String[] args) {
        Jump2 sol = new Jump2();
        int[] nums;
        int res;

        nums = new int[]{2,3,1,1,4};
        res = sol.jump(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + res);
    }
}
