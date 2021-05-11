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
/*abstract
1130. Minimum Cost Tree From Leaf Values

Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.

 

Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4

Ref: https://leetcode.com/problems/next-greater-element-ii/discuss/98270/JavaC++Python-Loop-Twice

dp[i, j] = dp[i, k] + dp[k + 1, j] + max(A[i, k]) * max(A[k + 1, j])
*/