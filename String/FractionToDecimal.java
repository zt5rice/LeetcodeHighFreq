import java.util.HashMap;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        FractionToDecimal sol = new FractionToDecimal();
        int numerator, denominator;
        String res;

        numerator = 1;
        denominator = 2;
        res = sol.fractionToDecimal(numerator, denominator);
        System.out.println("Input [a, b] : " + numerator + " / " + denominator);
        System.out.println("Output : " + res);
        
        numerator = 2;
        denominator = 1;
        res = sol.fractionToDecimal(numerator, denominator);
        System.out.println("Input [a, b] : " + numerator + " / " + denominator);
        System.out.println("Output : " + res);
        
        numerator = 2;
        denominator = 3;
        res = sol.fractionToDecimal(numerator, denominator);
        System.out.println("Input [a, b] : " + numerator + " / " + denominator);
        System.out.println("Output : " + res);
                
        numerator = 4;
        denominator = 333;
        res = sol.fractionToDecimal(numerator, denominator);
        System.out.println("Input [a, b] : " + numerator + " / " + denominator);
        System.out.println("Output : " + res);
    }
}
