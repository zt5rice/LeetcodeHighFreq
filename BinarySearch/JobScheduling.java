import java.util.Arrays;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int[] dp = new int[jobs.length];
        dp[jobs.length - 1] = jobs[jobs.length - 1][2];
        for (int cur = jobs.length - 2; cur >= 0; cur--) {
            int next = findNext(cur, jobs);
            dp[cur] = Math.max(
                jobs[cur][2] + (next == -1 ? 0 : dp[next]),
                dp[cur + 1]
            );
        }
        return dp[0];
    }
    
    private int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;   
            }
        }
        return -1;
    } 
    
    public static void main(String[] args) {
        JobScheduling sol = new JobScheduling();
        int[] startTime, endTime, profit;
        int res;
        startTime = new int[]{1,2,3,3};
        endTime = new int[]{3,4,5,6};
        profit = new int[]{50,10,40,70};

        res = sol.jobScheduling(startTime, endTime, profit);
        System.out.println("Result : " + res);
        
    }
}
/*abstract
1235. Maximum Profit in Job Scheduling
Hard

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

*/