import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<>(
        Map.of('(', ')', '{', '}','[', ']'));
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                parenthesis.push(mappings.get(c));
            } else if (mappings.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }
    
    public static void main(String[] args) {
        IsValidParentheses sol = new IsValidParentheses();
        String s;
        Boolean res;

        s = "()";
        res = sol.isValid(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "()[]{}";
        res = sol.isValid(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "(]";
        res = sol.isValid(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "([)]";
        res = sol.isValid(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
        
        s = "{[]}";
        res = sol.isValid(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
/*abstract
20. Valid Parentheses
Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

*/