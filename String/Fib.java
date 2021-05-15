public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int pp = 0;
        int p = 1;
        int cur = pp + p;
        int count = 2;
        while (count <= n) {
            cur = pp + p;
            pp = p;
            p = cur;
            count++;
        } // 
        return cur;
    }

    public static void main(String[] args) {
        Fib sol = new Fib();
        int n, res;

        n = 2;
        res = sol.fib(n);
        System.out.println("[n, fib(n)] : " + n + " , " + res);
    }
}
/*abstract
https://leetcode.com/problems/fibonacci-number/
*/