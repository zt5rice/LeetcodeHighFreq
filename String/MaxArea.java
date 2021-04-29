import java.util.Arrays;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
    public static void main(String[] args) {
        MaxArea sol = new MaxArea();
        int[] height;
        int res;

        height = new int[]{1,8,6,2,5,4,8,3,7};
        res = sol.maxArea(height);
        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + res);

        height = new int[]{1,1};
        res = sol.maxArea(height);
        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + res);

        height = new int[]{4,3,2,1,4};
        res = sol.maxArea(height);
        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + res);

        height = new int[]{1,2,1};
        res = sol.maxArea(height);
        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + res);
    }    
}
