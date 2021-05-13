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
    

    public int[] productExceptSelf2(int[] nums) { // sc: o(1)

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
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
/*abstract
https://leetcode.com/problems/product-of-array-except-self/


*/