import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.offerLast(cur);
                cur = 0;
            } else {
                cur = stack.pollLast() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

    public int scoreOfParentheses2(String S) {
        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') l++; else l--;
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') res += 1 << l;
        }
        return res;
    }
    public static void main(String[] args) {
        ScoreOfParentheses sol = new ScoreOfParentheses();
        String S;
        int res;

        S = "()";
        res = sol.scoreOfParentheses(S);
        System.out.println("Input  : " + S);
        System.out.println("Output : " + res);
    }
}
/*abstract
856. Score of Parentheses
Medium

Given a balanced parentheses string s, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

*/