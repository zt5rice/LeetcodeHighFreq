public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        } 
        // method - sliding window
        int maxLength = 0;
        int left = 0;
        int right = 0; // [left, right)
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            // 1. right move right, update map, max
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            right++;
            // 2. left move left, update map,
            while (map.size() > k) {
                char lChar = s.charAt(left);
                if (map.get(lChar) == 1) {
                    map.remove(lChar);
                } else {
                    map.put(lChar, map.get(lChar) - 1);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left); // [left, right)
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        LengthOfLongestSubstring sol = new LengthOfLongestSubstring();
        String s;
        int k, res;

        s = "eceba"; 
        k = 2;
        res = sol.lengthOfLongestSubstring(s);
        System.out.println("[s , k] : " + s + " , " + k);
        System.out.println("Output  : " + res);
    }
}


/*abstract

https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
*/