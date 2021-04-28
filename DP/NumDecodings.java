public class NumDecodings {
    public int numDecodings(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int[] dp = new int[s.length];
        dp[0] = s[0] != '0' ? 1 : 0;
        if (s.length == 1) {
            return dp[0];
        }
        if (s[1] != '0') {
            dp[1] += dp[0];
        }
        if (isValidTwoDigits(s, 0)) {
            dp[1]++;
        }
        for (int i = 2; i <= s.length - 1; i++) {
            if (s[i] != '0') {
                dp[i] += dp[i - 1];
            }
            if (isValidTwoDigits(s, i - 1)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length - 1];

    }

    public boolean isValidTwoDigits(char[] s, int left) {
        if (s[left] == '0') {
            return false;
        }
        int temp = Integer.valueOf(new String(s, left, 2));
        return temp >= 10 && temp <= 26;
    }

    public static void main(String[] args) {
        NumDecodings sol = new NumDecodings();
        String str;
        int res;

        str = "12";
        res = sol.numDecodings(str);
        System.out.println("Input  : " + str);
        System.out.println("Output : " + res);

        str = "226";
        res = sol.numDecodings(str);
        System.out.println("Input  : " + str);
        System.out.println("Output : " + res);

        str = "0";
        res = sol.numDecodings(str);
        System.out.println("Input  : " + str);
        System.out.println("Output : " + res);

        str = "06";
        res = sol.numDecodings(str);
        System.out.println("Input  : " + str);
        System.out.println("Output : " + res);
    }
}
