public class FindDistance {
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q) {
            return 0;
        }
        return recurseDistance(root, p, q, 0);
    }
    
    private int recurseDistance(TreeNode root, int a, int b, int depth) {
        int retVal = depth;
        if(root == null) {
        	// if we hit a null node => we did not pass either of the interested nodes, so return 0
            retVal = 0;
        } else if(root.val == a || root.val == b) {
        	// check for possibility of current node to be least common ancestor of other node
        	int left = recurseDistance(root.left, a, b, 1);
        	int right = recurseDistance(root.right, a, b, 1);
        	// we know that current node is one of interested node, so only left or right could have a positive value.  
        	// case 1: If either of them is positive, current node is indeed least common ancestor. So, distance is depth of the child node from current node
        	// case 2: If the other node did not fall into the descendants of current node, return current depth
        	retVal = (left>0 || right>0) ? Math.max(left, right) : retVal;           
        } else {
        	int left = recurseDistance(root.left, a, b, depth+1);
        	int right = recurseDistance(root.right, a, b, depth+1);
        	retVal = left+right;
            if(left!=0 && right!=0) {
            	// if both left child and right child are non-zero => current node is least common ancestor
            	// so, distance between node = (distance of left from here + distance of right from here)
            	// but we calculated the depth of left and right from root. So, remove the excess distance
            	// i.e., we calculated distance from root to current node twice unnecessarily. So, remove this from the sum
            	retVal -= 2*depth;
            }
        }
        return retVal;
    }    
}
