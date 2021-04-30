import java.util.Arrays;

public class Rotate0 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
      }
      public void reverse(int[] nums, int start, int end) {
        while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
      }
      public static void main(String[] args) {
          Rotate0 sol = new Rotate0();
          int[] nums;
          int k;

          nums = new int[]{1,2,3,4,5,6,7};
          k = 3;
          System.out.println("Input  : " + Arrays.toString(nums));
          System.out.println("Offset : " + k);
          sol.rotate(nums, k);
          System.out.println("Output : " + Arrays.toString(nums));  
          
          nums = new int[]{-1,-100,3,99};
          k = 2;
          System.out.println("Input  : " + Arrays.toString(nums));
          System.out.println("Offset : " + k);
          sol.rotate(nums, k);
          System.out.println("Output : " + Arrays.toString(nums));         
      }
}
