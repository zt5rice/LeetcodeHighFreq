import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peekLast() <= a) {
                int mid = stack.pollLast();
                res += mid * Math.min(stack.peekLast(), a);
            }
            stack.offerLast(a);
        }
        while (stack.size() > 2) {
            res += stack.pollLast() * stack.peekLast();
        }
        return res;        
    }    

    public static void main(String[] args) {
        MctFromLeafValues sol = new MctFromLeafValues();
        int[] arr;
        int res;

        arr = new int[]{6, 2, 4};
        res = sol.mctFromLeafValues(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);
    }
}
