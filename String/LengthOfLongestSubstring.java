import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // [i, j)
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        LengthOfLongestSubstring sol = new LengthOfLongestSubstring();
        String s;
        int res;

        s = "abcabcbb";
        res = sol.lengthOfLongestSubstring(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
        
        s = "bbbbb";
        res = sol.lengthOfLongestSubstring(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
        
        s = "pwwkew";
        res = sol.lengthOfLongestSubstring(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
                
        s = "";
        res = sol.lengthOfLongestSubstring(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
