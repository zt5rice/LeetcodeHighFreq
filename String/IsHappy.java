public class IsHappy {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = calc(n);
        }
        return (n == 1);
    }
    private int calc(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
    public static void main(String[] args) {
        IsHappy sol = new IsHappy();
        int n;
        boolean res;

        n = 19;
        res = sol.isHappy(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + res);
    }    
}
