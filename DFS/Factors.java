import java.util.*;

public class Factors { // 24
    public List<List<Integer>> factors(int num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> f = getAllFactors(num);
        List<Integer> cur = new ArrayList<>();
        dfs(num, 0, f, cur, res);
        return res;
    }

    private void dfs(int num, int index, List<Integer> f, List<Integer> cur, List<List<Integer>> res) {
        // base case
        if (index == f.size()) {
            if (num == 1) {
                res.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        // 1. not add
        dfs(num, index + 1, f, cur, res);
        // 2. adding factors of index
        int tmp = num;
        int tmpfac = f.get(index);
        int preSize = cur.size();
        while (tmp % tmpfac == 0) {
            cur.add(tmpfac);
            tmp /= tmpfac;
            dfs(tmp, index + 1, f, cur, res);
        }
        cur.subList(preSize, cur.size()).clear();
    }

    private List<Integer> getAllFactors(int num) {
        List<Integer> res = new ArrayList<>();
        int cur = num;
        while (cur > 1) {
            if (num % cur == 0) {
                res.add(cur);
            }
            cur--;
        }
        return res;
    }

    public static int getCombinations(int num, List<Integer> factors){
        int[][] dp = new int[factors.size() + 1][num + 1];
        for (int i = 1; i <= factors.size(); i++){
            for (int j = 1; j <= num; j++){
                if (j == 1){
                    dp[i][j] = 1;
                }
                else {
                    int temp = 0;
                    if (j%factors.get(i - 1) == 0){
                        temp = dp[i][j/factors.get(i - 1)];
                    }
                    dp[i][j] = dp[i - 1][j] + temp;
                }
            }
        } 
        return dp[factors.size()][num];
    }

    public static void main(String[] args) {
        Factors sol = new Factors();
        int num = 12;
        List<Integer> factors = sol.getAllFactors(num);
        System.out.println("Input  : " + num);
        System.out.println("Output : " + sol.factors(num));
        System.out.println("Factors: " + factors);
        System.out.println("# of comb:" + sol.getCombinations(num, factors));
    }
}
/*
 * Assumption: num >= 2 Method: dfs 1) find all factors not including 1 - n 12:
 * 12, 6, 4, 3, 2 12 /|\ 1 2 4 3
 */