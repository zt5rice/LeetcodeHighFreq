class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0; // [start end] - substring 
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // expand from left and right
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();
        String s;
        String rst;
        
        s = "babab";
        System.out.println("Input  :" + s);
        rst = sol.longestPalindrome(s);
        System.out.println("Result :" + rst);

        s = "cbbd";
        System.out.println("Input  :" + s);
        rst = sol.longestPalindrome(s);
        System.out.println("Result :" + rst);

        s = "a";
        System.out.println("Input  :" + s);
        rst = sol.longestPalindrome(s);
        System.out.println("Result :" + rst);

        s = "ac";
        System.out.println("Input  :" + s);
        rst = sol.longestPalindrome(s);
        System.out.println("Result :" + rst);
    }
}
/*abstract
c: i - String, o - String
a: not null
r: dp - expand from center
t

tc: o(n2)
sc: o(n)
*/