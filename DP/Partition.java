/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        Partition sol = new Partition();
        String s;
        List<List<String>> res;

        s = "aab";
        res = sol.partition(s);
        System.out.println("Input : " + s);
        for(List<String> innerLs : res) {
            System.out.println(Arrays.toString(innerLs.toArray()));;
        }

        s = "a";
        res = sol.partition(s);
        System.out.println("Input : " + s);
        for(List<String> innerLs : res) {
            System.out.println(Arrays.toString(innerLs.toArray()));;
        }
    }
}
