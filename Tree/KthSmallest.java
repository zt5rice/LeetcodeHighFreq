public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.offerLast(p);    // Just like recursion
                p = p.left;   

            } else {
               TreeNode node = stack.pollLast();
               if(++count == k) return node.val; 
               p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }    
}
/*abstract

Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/