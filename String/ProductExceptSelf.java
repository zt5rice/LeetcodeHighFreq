import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        int[] res = new int[len];
        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = l[i] * r[i];   
        } 
        return res;
    }
    
    public static void main(String[] args) {
        ProductExceptSelf sol = new ProductExceptSelf();
        int[] nums, res;

        nums = new int[]{1,2,3,4};
        res = sol.productExceptSelf(nums);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : "  + Arrays.toString(res));
    }
}
