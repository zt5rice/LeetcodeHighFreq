import java.util.Arrays;

public class CountBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
          ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
    public static void main(String[] args) {
        CountBits sol = new CountBits();
        int num;
        int[] res;

        num = 2;
        res = sol.countBits(num);
        System.out.println("Input  : " + num);
        System.out.println("Output : " + Arrays.toString(res));
    }    
}
