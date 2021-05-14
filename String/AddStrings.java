public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int rem = 0;
        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int val = (n1 + n2 + rem) % 10;
            rem = (n1 + n2 + rem) / 10; // not val / 10, since processed
            sb.append(val);
            p1--;
            p2--;
        }
        if (rem != 0) {
            sb.append(rem);
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        AddStrings sol = new AddStrings();
        String num1, num2;
        String res;

        num1 = "11";
        num2 = "123";
        res = sol.addStrings(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + res);
    }
}
/*abstract
https://leetcode.com/problems/add-strings/

*/