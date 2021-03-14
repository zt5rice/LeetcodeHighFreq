/*
179. All Valid Permutations Of Parentheses II
Hard
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
*/
import java.util.*;
public class ValidParentheses {
    private static final char[] p = {'(', ')', '<', '>', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
      List<String> res = new ArrayList<>();
      char[] cur = new char[2*l + 2*m + 2*n];
      int[] pinfo = {l, l, m, m, n, n};
      Deque<Character> stack = new LinkedList<>();
      helper(cur, 0, pinfo, stack, res);
      return res;
    }
    private void helper(char[] cur, int index, int[] pinfo, Deque<Character> stack, List<String> res) {
      // base case: index == cur.length;
      if (index == cur.length) {
        res.add(new String(cur));
        return;
      }
      for (int i = 0; i < p.length; i++) {
        if (i % 2 == 0) { // left para
          if (pinfo[i] > 0) {
            cur[index] = p[i];
            stack.offerFirst(p[i]);
            pinfo[i]--;
            helper(cur, index + 1, pinfo, stack, res);
            stack.pollFirst();
            pinfo[i]++;
          }
        } else { // right para
          if (!stack.isEmpty() && stack.peekFirst() == p[i-1]) {
            cur[index] = p[i];
            stack.pollFirst(); // p[i-1]++;
            pinfo[i]--;
            helper(cur, index + 1, pinfo, stack, res);
            stack.offerFirst(p[i-1]); 
            pinfo[i]++;         
          }
        }
      }
      // for all para, check valid, p[i], i%2== 0, left; 
      // left, ok? remain > 0
      // update, push into stack, add to cur
      // back, pushout stack, index back
  
      // right, stack.peekFirst() == i-1 remain > 0
      // update: push out p[i-1] from stack, add to cur
      // back: push back p[i-1] from stack, 
  
    }
    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        int[] input = {1,1,1};
        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Output:" + sol.validParentheses(input[0], input[1], input[2]));
    }
}
