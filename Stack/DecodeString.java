import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }       
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder buffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num = num * 10 + arr[i] - '0';
            } else if (Character.isLetter(arr[i])){
                buffer.append(arr[i]);
            } else if (arr[i] == '[') {
                strStack.offerLast(buffer);
                buffer = new StringBuilder();
                numStack.offerLast(num);
                num = 0;
            } else if (arr[i] ==']') {
                sb = new StringBuilder();
                sb.append(strStack.pollLast());                
                int tmpNum = numStack.pollLast();
                for (int j = tmpNum; j > 0; j--) {
                    sb.append(buffer);
                }
                buffer = sb;
            }
        }
        return buffer.toString();
    }
    
    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        String s, res;

        s = "3[a]2[bc]";
        System.out.println("Input  : " + s);
        res = sol.decodeString(s);
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/decode-string/

*/