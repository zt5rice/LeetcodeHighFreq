import java.util.Arrays;

public class SortedArrayToBST {
    int[] nums;

    public TreeNode helper(int left, int right) {
      if (left > right) return null;
  
      // always choose left middle node as a root
      int p = (left + right) / 2;
  
      // preorder traversal: node -> left -> right
      TreeNode root = new TreeNode(nums[p]);
      root.left = helper(left, p - 1);
      root.right = helper(p + 1, right);
      return root;
    }
  
    public TreeNode sortedArrayToBST(int[] nums) {
      this.nums = nums;
      return helper(0, nums.length - 1);
    }

    public static void main(String[] args) {
        SortedArrayToBST sol = new SortedArrayToBST();
        ConstructTree construct = new ConstructTree();
        int[] nums;
        Integer[] resInt;
        TreeNode res;

        nums = new int[]{-10,-3,0,5,9};
        res = sol.sortedArrayToBST(nums);
        resInt = construct.destructTree(res);
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(resInt));
    }
}
/*abstract
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/