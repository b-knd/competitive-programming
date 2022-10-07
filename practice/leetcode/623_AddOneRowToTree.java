//O(V+E) time complexity

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //level is before root
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        
        recurse(root, val, depth-1, 1);
        return root;
    }

    public void recurse(TreeNode node, int val, int depth, int currDepth){
        if(node == null){
            return;
        }
        
        //add one row (update left and right children)
        if(currDepth == depth){
            TreeNode newLeft = new TreeNode(val), newRight = new TreeNode(val);
            TreeNode leftChild = node.left, rightChild = node.right;
            node.left = newLeft;
            node.right = newRight;
            newLeft.left = leftChild;
            newRight.right = rightChild;
        }
      
        //continue recursing only if we have not reach the depth
        if(currDepth < depth){
            recurse(node.left, val, depth, currDepth+1);
            recurse(node.right, val, depth, currDepth+1);
        }
    }
}
