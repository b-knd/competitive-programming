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
    int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
    
    public void preorder(TreeNode node, int path) {
        if(node != null){
            //use XOR to find lone values
            path = path ^ (1 << node.val);
            
            //leaf node, check to see (only allow at most 1 lone value)
            if(node.left == null && node.right == null){
                if((path & (path-1)) == 0) {
                    ++count;
                }
            }
            
            //keep on traversing (dfs)
            preorder(node.left, path);
            preorder(node.right, path);
        }
    }
}
