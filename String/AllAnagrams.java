/*
438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/
import java.util.*;
public class AllAnagrams {
    public static void main(String[] args) {
        AllAnagrams sol = new AllAnagrams();
        String s = "ab";
        String l = "baaadabba";
        System.out.println(s);
        System.out.println(l);        
        List<Integer> res = sol.allAnagrams(s, l);
        System.out.println(res.toString());
    }
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
            if(l.length() == 0) {
                return result;
            }
            if(s.length()>l.length()) {
                return result;
            }
            Map<Character, Integer>map = countMap(s);
            int match = 0;
            for(int i = 0; i < l.length(); i++) {
                char tmp = l.charAt(i);
                Integer count = map.get(tmp);
                if(count != null) {
                    map.put(tmp, count-1);
                    if(count == 1) {
                        match++;
                    }
                }
                if(i >=s.length()) {
                    tmp = l.charAt(i-s.length());
                    count = map.get(tmp);
                    if(count != null) {
                        map.put(tmp, count+1);
                        if(count == 0) {
                            match--;
                        }
                    }
                }
                System.out.print(l.substring(i < s.length() ? 0 : i - s.length() +1, i + 1) + "; right = " + i + " match = " + match + "; ");
                System.out.println(Arrays.asList(map));
                if(match == map.size()) {
                    result.add(i-s.length()+1);
                }
            }
            return result;
      }
    
      private Map<Character, Integer> countMap(String s){
            Map<Character, Integer>map = new HashMap<>();
            for(char ch: s.toCharArray()) {
                Integer count = map.get(ch);
                if(count == null) {
                    map.put(ch, 1);
                }else {
                    map.put(ch, count+1);
                }
            }
            return map;
        }
    }
