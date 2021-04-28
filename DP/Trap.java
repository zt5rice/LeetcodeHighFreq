import java.util.Arrays;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

*/
public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int rst = 0;
        int left = 0;
        int lh = 0;
        int right = height.length - 1; // [0, left) (right, end]
        int rh = height[right];
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= lh) {
                    lh = height[left];
                }  else {
                    rst += (lh - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rh) {
                   rh = height[right];
                } else {
                    rst += (rh - height[right]);
                }
                    right--;
            }
        }
        return rst;
    }    
    public static void main(String[] args) {
        Trap sol = new Trap();
        int[] height;
        int res;

        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Input  : " + Arrays.toString(height));
        res = sol.trap(height);
        System.out.println("Output : " + Integer.toString(res));

        height = new int[]{4,2,0,3,2,5};
        System.out.println("Input  : " + Arrays.toString(height));
        res = sol.trap(height);
        System.out.println("Output : " + Integer.toString(res));
    }
}
