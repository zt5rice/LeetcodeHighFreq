/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

    3
*/

class MyPow {
    public double myPow(double x, long n) {
        if (x == 0.0 && n != 0) {
            return x;
        }
        if (n == 0) {
            return (double) 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            x = 1 / x;
            n = -n;           
        }
        double half = myPow(x, n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
    // ref & explanation : https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
    public double MyPowIter(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
    public static void main(String[] args) {
        MyPow sol = new MyPow();
        double x = 2.1;
        int n = 3;
        System.out.println("x = " + Double.toString(x));
        System.out.println("n = " + Integer.toString(n));
        System.out.println("Pow(x, n) = " + sol.myPow(x, n));
        x = 2.0;
        n = 10;
        System.out.println("x = " + Double.toString(x));
        System.out.println("n = " + Integer.toString(n));
        System.out.println("Pow(x, n) = " + sol.myPow(x, n));
        x = 2.0;
        n = -2;
        System.out.println("x = " + Double.toString(x));
        System.out.println("n = " + Integer.toString(n));
        System.out.println("Pow(x, n) = " + sol.myPow(x, n));
    }
}
/*
c: i - double x, long n; o - double
a: x +-, n +-
method: iterative, binary search
1) n < 0 ? x = 1.0/x, n = -n : x;

r: 
*/