import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
    
        return newNumber;
    }
    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        int[] digits;
        int[] res;

        digits = new int[]{1,2,3};
        System.out.println("Input  : " + Arrays.toString(digits));        
        res = sol.plusOne(digits);
        System.out.println("Output : " + Arrays.toString(res));

        digits = new int[]{4,3,2,1};
        System.out.println("Input  : " + Arrays.toString(digits));        
        res = sol.plusOne(digits);
        System.out.println("Output : " + Arrays.toString(res));
        
        digits = new int[]{9};
        System.out.println("Input  : " + Arrays.toString(digits));        
        res = sol.plusOne(digits);
        System.out.println("Output : " + Arrays.toString(res));
    }
}
