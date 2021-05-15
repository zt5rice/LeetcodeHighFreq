public class IsPalindrome {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome sol = new IsPalindrome();
        String s;
        boolean res;

        s = "A man, a plan, a canal: Panama";
        res = sol.isPalindrome(s);
        System.out.println("Input  : " + s);
        System.out.println("Output " + res);

        s = "race a car";
        res = sol.isPalindrome(s);
        System.out.println("Input  : " + s);
        System.out.println("Output " + res);
    }
}
