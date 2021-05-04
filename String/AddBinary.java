import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        AddBinary sol = new AddBinary();
        String a, b, res;

        a = "11"; 
        b = "1";
        res = sol.addBinary(a, b);
        System.out.println("Input [a, b] : " + a + " , " + b);
        System.out.println("Output : " + res);

        a = "1010"; 
        b = "1011";
        res = sol.addBinary(a, b);
        System.out.println("Input [a, b] : " + a + " , " + b);
        System.out.println("Output : " + res);
    }    
}
