import java.util.*;

public class KeepDistance {
    public static void main(String[] args) {
        KeepDistance sol = new KeepDistance();
        int k = 3;
        System.out.println(Arrays.toString(sol.keepDistance2(k)));
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
}
/*
 * 24 Method: dfs, coin, choose, quick return
 * 
 * 
 */