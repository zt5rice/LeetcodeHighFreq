public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        } 
        return count;
    }
    
    public static void main(String[] args) {
        CountPrimes sol = new CountPrimes();
        int n, res;

        n = 10;
        res = sol.countPrimes(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + res);
    }
}
