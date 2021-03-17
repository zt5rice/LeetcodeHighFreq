import java.util.*;

public class CombSol {
    public static void main(String[] args) {
        CombSol sol = new CombSol();
        int k = 3;
        System.out.println(Arrays.toString(sol.comb(k).toArray()));
    }

    public List<String> comb(int k) {
        int[] cur = new int[k * 2];
        List<String> res = new ArrayList<>();
        dfs(cur, 1, res);

        return res;
    }

    private void dfs(int[] cur, int i, List<String> res) {
        // base case
        if (i == cur.length / 2 + 1) {
            res.add(Arrays.toString(cur));
            return;
        }
        int k = cur.length / 2;
        // put the i into the cur
        for (int j = 0; j <= 2 * k - (i + 2); j++) { //
            if (cur[j] == 0 && cur[j + i + 1] == 0) {
                cur[j] = i;
                cur[j + i + 1] = i;
                dfs(cur, i + 1, res);
                cur[j] = 0;
                cur[j + i + 1] = 0;
            }
        }
    }

}
