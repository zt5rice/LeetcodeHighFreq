public class Calculate2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int cur = 0;
        int last = 0;
        int res = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                cur = (cur * 10) + (curChar - '0');
            }
            if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == len - 1) {
                if (operation == '+' || operation == '-') {
                    res += last;
                    last = (operation == '+') ? cur : - cur;
                } else if (operation == '*') {
                    last = last * cur;
                } else if (operation == '/') {
                    last = last / cur;
                }
                operation = curChar;
                cur = 0;            
            }
        }
        res += last;
        return res;
    }    

    public static void main(String[] args) {
        Calculate2 sol = new Calculate2();
        String s;
        int res;

        s = "(1+(4+5+2)-3)+(6+8)";
        res = sol.calculate(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
