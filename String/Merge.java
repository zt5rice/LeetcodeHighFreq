import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;
    
        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
          // compare two elements from nums1 and nums2 
          // and add the largest one in nums1 
          nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    
        // add missing elements from nums2
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
      }
      public static void main(String[] args) {
          Merge sol = new Merge();
          int[] nums1, nums2;
          int m, n;

          nums1 = new int[] {1,2,3,0,0,0}; 
          m = 3;
          nums2 = new int[]{2,5,6};
          n = 3;
          System.out.println("Input Array 1 :" + Arrays.toString(nums1));
          System.out.println("Input Array 2 :" + Arrays.toString(nums2));  
          System.out.println("m : " + m);
          System.out.println("n : " + n);
          sol.merge(nums1, m, nums2, n);
          System.out.println("Output Array 1 :" + Arrays.toString(nums1));
      }
}
