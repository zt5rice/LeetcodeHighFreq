import java.util.Arrays;
import java.util.HashMap;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    
    public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2, Map<Integer, Integer> map) {
        if(s1 > e1) return null;
        //if(s1 == e1) return new TreeNode(preorder[s1]);
  
        TreeNode root = new TreeNode(preorder[s1]);
        
        int m = map.get(root.val);
        
        root.left = buildTree(preorder, s1 + 1, s1 + m - s2, inorder, s2, m - 1, map);
        root.right = buildTree(preorder, s1 + m - s2 + 1, e1, inorder, m + 1, e2, map);
        
        return root;
    }     
    
    public static void main(String[] args) {
        BuildTree105 sol = new BuildTree105();
        ConstructTree r = new ConstructTree();
        int[] preorder, inorder;
        TreeNode res;

        preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        res = sol.buildTree(preorder, inorder);
        System.out.println("Result : " + Arrays.toString(r.destructTree(res).toString()));
    }
}
