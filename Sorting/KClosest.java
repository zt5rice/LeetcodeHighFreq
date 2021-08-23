import java.util.*;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        quickSelect(result, points, k);
        return result;
    }

    public static Random rand = new Random();

    public void quickSelect(int[][] result, int[][] points, int k) {

        int left = 0;
        int right = points.length - 1;
        // [left..right] is the sorting area
        while (left < right) {
            int pivot = left + rand.nextInt(right - left + 1);
            int[] pivPoint = points[pivot];
            int pivDis = pivPoint[0] * pivPoint[0] + pivPoint[1] * pivPoint[1];
            swap(points, pivot, right);

            int i = left; // [0..i-1] are smaller than or equal to piv
            int j = right - 1; // [j + 1.. right] are bigger than piv
            // [i..j] are undiscovered
            while (i <= j) {
                int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];

                if (dis <= pivDis) {
                    i++;
                } else {
                    swap(points, i, j);
                    j--;
                }
            }
            swap(points, i, right);
            if (i == k) {
                break;
            } else if (i < k) {
                left = i + 1;
            } else {
                right = i - 1;
            }

        }

        getResult(result, points, k);

    }

    public void getResult(int[][] result, int[][] points, int k) {
        int i = 0;
        while (i <= k - 1) {
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
            i++;
        }
    }

    public void swap(int[][] points, int i, int j) {
        int temp0 = points[i][0];
        int temp1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = temp0;
        points[j][1] = temp1;
    }

    public static void main(String[] args) {
        KClosest sol = new KClosest();
        int[][] points, res;
        int k;
        
        points = new int[][]{{3,3},{5,-1},{-2,4}};
        k = 2;
        res = sol.kClosest(points, k);
        System.out.println("Input  : " + Arrays.deepToString(points));
        System.out.println("k : " + k);
        System.out.println("Output : " + Arrays.deepToString(res));
    }
}
/*abstract

973. K Closest Points to Origin
Medium

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104

*/