import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    static char[][] pad = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[] arr = digits.toCharArray();
        char[] tmp = new char[arr.length];
        helper(arr, 0, tmp, res);
        return res;
    }

    private void helper(char[] arr, int index, char[] tmp, List<String> res) {
        if (index == arr.length) {
            res.add(new String(tmp));
            return;
        } // base case;
        int num = arr[index] - '1' - 1;
        for (int i = 0; i < pad[num].length; i++) {
            tmp[index] = pad[num][i];
            helper(arr, index + 1, tmp, res);
        }
    }

    public static void main(String[] args) {
        LetterCombinations sol = new LetterCombinations();
        String digits;
        List<String> res;

        digits = "23";
        res = sol.letterCombinations(digits);
        System.out.println("Input   : " + digits);
        System.out.println("Results : " + Arrays.toString(res.toArray()));
    }
}
/*abstract
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/