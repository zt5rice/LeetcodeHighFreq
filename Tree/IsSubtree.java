import java.util.Arrays;

public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.key != t.key) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        IsSubtree sol = new IsSubtree();
        ConstructTree construct = new ConstructTree();
        Integer[] rootInt, subrootInt;
        TreeNode root, subroot;
        boolean res;

        rootInt = new Integer[]{3,4,5,1,2};
        subrootInt = new Integer[]{4,1,2};
        root = construct.constructTree(rootInt);
        subroot = construct.constructTree(subrootInt);
        res = sol.isSubtree(root, subroot);
        System.out.println("Tree 1 : " + Arrays.toString(rootInt));
        System.out.println("Tree 2 : " + Arrays.toString(subrootInt));
        System.out.println("Is subtree ? " + res);

        rootInt = new Integer[]{3,4,5,1,2,null,null,null,null,0};
        subrootInt = new Integer[]{4,1,2};
        root = construct.constructTree(rootInt);
        subroot = construct.constructTree(subrootInt);
        res = sol.isSubtree(root, subroot);
        System.out.println("Tree 1 : " + Arrays.toString(rootInt));
        System.out.println("Tree 2 : " + Arrays.toString(subrootInt));
        System.out.println("Is subtree ? " + res);
    }
}
/*abstract
https://leetcode.com/problems/subtree-of-another-tree/
*/