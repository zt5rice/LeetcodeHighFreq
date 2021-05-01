import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Runtime: 15 ms, faster than 29.34% 
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }  
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] strs;
        List<List<String>> res;

        strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        res = sol.groupAnagrams(strs);
        System.out.println("Input  : " + Arrays.toString(strs));
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }  
}
