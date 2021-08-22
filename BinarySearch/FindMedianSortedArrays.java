import java.util.*;

class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if(len % 2 == 0){
            double left =  (double)findKthHelper(nums1, 0, nums2, 0, len/2);
            double right =  (double)findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
            return (double)(left+right)/2;
        }else{
            return findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
        }
    }
    private int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k){
        if(aStart >= A.length){
            return B[bStart + k - 1];
        }
        if(bStart >= B.length){
            return A[aStart + k - 1];
        }
        if(k == 1){
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = aStart + k/2 - 1; 
        int bMid = bStart + k/2 - 1;
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
        if(aVal <= bVal){
            return findKthHelper(A, aMid + 1, B, bStart, k - k/2);
        }else{
            return findKthHelper(A, aStart, B, bMid + 1, k - k/2);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays sol = new FindMedianSortedArrays();
        int[] nums1, nums2;
        double res;
        
        nums1 = new int[]{1,3};
        nums2 = new int[]{2};
        res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Input array 1 : "+Arrays.toString(nums1));
        System.out.println("Input array 2 : "+Arrays.toString(nums2));
        System.out.format("Result : %.5f%n%n",res);

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Input array 1 : "+Arrays.toString(nums1));
        System.out.println("Input array 2 : "+Arrays.toString(nums2));
        System.out.format("Result : %.5f%n%n",res);

        nums1 = new int[]{0,0};
        nums2 = new int[]{0,0};
        res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Input array 1 : "+Arrays.toString(nums1));
        System.out.println("Input array 2 : "+Arrays.toString(nums2));
        System.out.format("Result : %.5f%n%n",res);

        nums1 = new int[]{};
        nums2 = new int[]{1};
        res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Input array 1 : "+Arrays.toString(nums1));
        System.out.println("Input array 2 : "+Arrays.toString(nums2));
        System.out.format("Result : %.5f%n%n",res);

        nums1 = new int[]{2};
        nums2 = new int[]{};
        res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Input array 1 : "+Arrays.toString(nums1));
        System.out.println("Input array 2 : "+Arrays.toString(nums2));
        System.out.format("Result : %.5f%n%n",res);
    }
}

/*abstract

4. Median of Two Sorted Arrays

Hard

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

*/