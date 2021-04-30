import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    static Map<String, Integer> value = new HashMap<>();
    static {
        value.put("M", 1000);
        value.put("D", 500);
        value.put("C", 100);
        value.put("L", 50);
        value.put("X", 10);
        value.put("V", 5);
        value.put("I", 1);
    }
    public int romanToInt(String s) {
        String lastSym = s.substring(s.length() - 1);
        int lastVal = value.get(lastSym);
        int tot = lastVal;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            String curSym = s.substring(i, i + 1);
            int curVal = value.get(curSym);
            if (curVal < lastVal) {
                tot -= curVal;
            } else {
                tot += curVal;
            }
            lastVal = curVal;
        }
        return tot;
    }  
    
    public static void main(String[] args) {
        RomanToInt sol = new RomanToInt();
        String s;
        int res;

        s = "III";
        res = sol.romanToInt(s);
        System.out.println("Roman  : " + s);
        System.out.println("Result : " + res);
        
        s = "IV";
        res = sol.romanToInt(s);
        System.out.println("Roman  : " + s);
        System.out.println("Result : " + res);
        
        s = "IX";
        res = sol.romanToInt(s);
        System.out.println("Roman  : " + s);
        System.out.println("Result : " + res);
        
        s = "LVIII";
        res = sol.romanToInt(s);
        System.out.println("Roman  : " + s);
        System.out.println("Result : " + res);
                
        s = "MCMXCIV";
        res = sol.romanToInt(s);
        System.out.println("Roman  : " + s);
        System.out.println("Result : " + res);
    }
}
