public class Divide {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;        
    }
    public static void main(String[] args) {
        Divide sol = new Divide();
        int dividend,  divisor, res;
        dividend = 10;
        divisor = 3;
        res = sol.divide(dividend, divisor);
        System.out.println(dividend + "/" + divisor + "=" + res);
    }
}
/*abstract
https://leetcode.com/problems/divide-two-integers/
*/
