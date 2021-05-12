import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] array) {
        int res = 0;
        if (array == null || array.length == 0) {
            return res;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.poll()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                res = Math.max(res, (i - left) * height);
            }
            stack.offerFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleArea sol = new LargestRectangleArea();
        int[] height;
        int res;
        height = new int[] { 2, 1, 5, 6, 2, 3 };
        res = sol.largestRectangleArea(height);
        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + res);
    }
}
