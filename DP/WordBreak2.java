import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak2 {
    public List<String> wordBreak1(String s, List<String> words) {
        Set<String> wordDict = new HashSet<String>(words);
        List<Integer>[] starts = new List[s.length() + 1]; // valid start positions
        starts[0] = new ArrayList<Integer>();

        int maxLen = getMaxLen1(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= i - maxLen && j >= 0; j--) {
                if (starts[j] == null) continue;
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    if (starts[i] == null) {
                        starts[i] = new ArrayList<Integer>();
                    }
                    starts[i].add(j);
                }
            }
        }

        List<String> rst = new ArrayList<>();
        if (starts[s.length()] == null) {
            return rst;
        }

        dfs1(rst, "", s, starts, s.length());
        return rst;
    }


    private void dfs1(List<String> rst, String path, String s, List<Integer>[] starts, int end) {
        if (end == 0) {
            rst.add(path.substring(1));
            return;
        }

        for (Integer start: starts[end]) {
            String word = s.substring(start, end);
            dfs1(rst, " " + word + path, s, starts, start);
        }
    }

    private int getMaxLen1(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }
    // Method 1. DFS w backtracking: https://leetcode.com/problems/word-break-ii/discuss/44243/Java-DP%2BDFS-Memoization%2BDFS-and-DP-Pruning-Solutions-with-Analysis
    public static void main(String[] args) {
        WordBreak2 sol = new WordBreak2();
        String s;
        List<String> wordDict;
        List<String> res;

        s = "catsanddog";
        wordDict = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});
        System.out.println("Input     : " + s);
        System.out.println("Dictionary: " + Arrays.toString(wordDict.toArray()));
        res = sol.wordBreak1(s, wordDict);
        System.out.println("Output : " + res);        
    }
}