import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        String s;
        List<String> wordDict;
        boolean res;

        s = "leetcode";
        wordDict = Arrays.asList(new String[]{"leet","code"});
        System.out.println("Input     : " + s);
        System.out.println("Dictionary: " + Arrays.toString(wordDict.toArray()));
        res = sol.wordBreak(s, wordDict);
        System.out.println("Breakable ? " + res);
        
        s = "applepenapple";
        wordDict = Arrays.asList(new String[]{"apple","pen"});
        System.out.println("Input     : " + s);
        System.out.println("Dictionary: " + Arrays.toString(wordDict.toArray()));
        res = sol.wordBreak(s, wordDict);
        System.out.println("Breakable ? " + res);

        s = "catsandog";
        wordDict = Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        System.out.println("Input     : " + s);
        System.out.println("Dictionary: " + Arrays.toString(wordDict.toArray()));
        res = sol.wordBreak(s, wordDict);
        System.out.println("Breakable ? " + res);
    }
}
