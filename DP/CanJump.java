import java.util.Arrays;

public class CanJump {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }

    public boolean canJump2(int[] nums) { // DP, tc : o(n2), sc: o(n)
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        CanJump sol = new CanJump();
        int[] A;
        boolean res;

        A = new int[]{2,3,1,1,4};
        res = sol.canJump(A);
        System.out.println("Input  : " + Arrays.toString(A));
        System.out.println("Output : " + res);
    
        A = new int[]{3,2,1,0,4};
        res = sol.canJump(A);
        System.out.println("Input  : " + Arrays.toString(A));
        System.out.println("Output : " + res);
    }
}
