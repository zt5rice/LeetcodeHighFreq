import jdk.incubator.jpackage.main.Main;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsAnagram sol = new IsAnagram();
        String s, t;
        Boolean res;

        s = "anagram";
        t = "nagaram";
        res = sol.isAnagram(s, t);
        System.out.println("[s, t] : " + s + " , " + t);
        System.out.println("Output : " + res);

    }
}
/*abstract
https://leetcode.com/problems/valid-anagram/

*/