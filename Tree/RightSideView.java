import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.key);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
    
    
}
