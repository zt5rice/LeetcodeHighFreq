public class CountBinarySubstrings {
    // public int countBinarySubstrings(String s) {
    //     int[] groups = new int[s.length()];
    //     int t = 0;
    //     groups[0] = 1;
    //     for (int i = 1; i < s.length(); i++) {
    //         if (s.charAt(i-1) != s.charAt(i)) {
    //             groups[++t] = 1;
    //         } else {
    //             groups[t]++;
    //         }
    //     }

    //     int ans = 0;
    //     for (int i = 1; i <= t; i++) {
    //         ans += Math.min(groups[i-1], groups[i]);
    //     }
    //     return ans;
    // }
    
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }

    public static void main(String[] args) {
        CountBinarySubstrings sol = new CountBinarySubstrings();
        String s;
        int res;

        s = "00110011";
        res = sol.countBinarySubstrings(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
