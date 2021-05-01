public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString(); // special cases for empty
    }    

    public static void main(String[] args) {
        Multiply sol = new Multiply();
        String num1, num2, res;

        num1 = "2";
        num2 = "3";
        res = sol.multiply(num1, num2);
        System.out.println("Input  : " + num1 + " , " + num2);
        System.out.println("Output : " + res);

        num1 = "123";
        num2 = "456";
        res = sol.multiply(num1, num2);
        System.out.println("Input  : " + num1 + " , " + num2);
        System.out.println("Output : " + res);

        num1 = "987654321";
        num2 = "123456789";
        res = sol.multiply(num1, num2);
        System.out.println("Input  : " + num1 + " , " + num2);
        System.out.println("Output : " + res);
    }
}
