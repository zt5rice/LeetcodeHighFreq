public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }
    
    /* Check is s[i...j] is palindrome. */
    private boolean isPalindrome(String s, int i, int j) {
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        ValidPalindrome2 sol = new ValidPalindrome2();
    
        String s;
        boolean res;

        s = "abca";
        res = sol.validPalindrome(s);
        System.out.println("Input  : " + s);
        System.out.println("Output :" + res);

        s = "aba";
        res = sol.validPalindrome(s);
        System.out.println("Input  : " + s);
        System.out.println("Output :" + res);
    }
}

/*abstract
https://leetcode.com/problems/valid-palindrome-ii/

*/