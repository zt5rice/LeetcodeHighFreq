import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        return strs[0];
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        String[] strs;
        String res;

        strs = new String[]{"flower","flow","flight"};
        res = sol.longestCommonPrefix(strs);
        System.out.println("Input         : " + Arrays.toString(strs));
        System.out.println("Common Prefix : " + res);
        
        strs = new String[]{"dog","racecar","car"};
        res = sol.longestCommonPrefix(strs);
        System.out.println("Input         : " + Arrays.toString(strs));
        System.out.println("Common Prefix : " + res);
    }
}
/* Method: Vertical scanning

*/
