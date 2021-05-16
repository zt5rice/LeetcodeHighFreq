import java.util.Arrays;
import java.util.HashMap;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);        
    }

    public static void main(String[] args) {
        Intersect sol = new Intersect();
        int[] nums1, nums2, res;
        nums1 = new int[]{1,2,2,1};
        nums2 = new int[]{2,2};
        res = sol.intersect(nums1, nums2);
        System.out.println("Input 1 : " + Arrays.toString(nums1));
        System.out.println("Input 2 : " + Arrays.toString(nums2));
        System.out.println("Output  : " + Arrays.toString(res));
    }
}
/*abstract


https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/