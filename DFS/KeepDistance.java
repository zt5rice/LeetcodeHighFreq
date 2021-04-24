import java.util.*;
/*
264. Keep Distance For Identical Elements(C++ not ready)
Medium
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

If there does not exist such sequence, return null.

Assumptions:

k is guaranteed to be > 0
Examples:

k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
*/
public class KeepDistance {
    public static void main(String[] args) {
        KeepDistance sol = new KeepDistance();
        int k = 3;
        System.out.println(Arrays.toString(sol.keepDistance3(k)));
    }

    public int[] keepDistance(int k) {
        int[] cur = new int[2 * k];
        return dfs(cur, k) ? cur : null;
    }

    private boolean dfs(int[] cur, int k) { // can put k elements?
        if (k == 0) {
            return true;
        }
        for (int i = 0; i < cur.length - (i + 2) + 1; i++) {
            if (cur[i] == 0 && cur[i + k + 1] == 0) {
                cur[i] = k;
                cur[i + k + 1] = k;

                if (dfs(cur, k - 1)) {
                    return true;
                }
                cur[i] = 0;
                cur[i + k + 1] = 0;
            }
        } // 2 0 0 2
        return false;
    }
    // normal order
    public int[] keepDistance2(int k) {
        int[] arr = new int[2*k];
        if (dfs2(arr, 1, k)) {
            return arr;
        }
        return null;
    } 
    private boolean dfs2(int[] arr, int i, int k) {
        if (i == k + 1) {
            return true;
        }
        // add i into arr
        for (int j = 0; j < arr.length - (j + 1); j++) {
            if (arr[j] == 0 && arr[j + i + 1] == 0) {
                arr[j] = i;
                arr[j + i + 1] = i;
                if (dfs2(arr, i+1, k)) {
                    return true;
                }
                arr[j] = 0;
                arr[j + i + 1] = 0; 
            }
        } // 2 0 0 2 
        return false;
    }
    public int[] keepDistance3(int k) {
        int[] res = new int[2*k];
        return dfs3(res, k, 1) ? res : null;
      }
      private boolean dfs3(int[] res, int k, int i) {
        if (i== k +1) {
          return true;
        }
        for (int j = 0; j < 2*k - i - 1; j++) { // size: i+2, 2k-i-2,   4 - 
          if (res[j] == 0 && res[j + i + 1] == 0) {
            res[j] = i;
            res[j + i + 1] = i;
            if (dfs3(res, k, i+1)) {
                return true;
            }
            res[j] = 0;
            res[j + i + 1] = 0; 
          }
        }
        return false;
      }
}
/*
 * 24 Method: dfs, coin, choose, quick return
 * 
 * 
 */