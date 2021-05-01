public class IsNumber {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;        
    }
    
    public static void main(String[] args) {
        IsNumber sol = new IsNumber();
        String s;
        Boolean res;

        s = "0";
        res = sol.isNumber(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "e";
        res = sol.isNumber(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = ".";
        res = sol.isNumber(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    
        s = ".1";
        res = sol.isNumber(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
