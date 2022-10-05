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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode node, int targetSum, int currSum){
        if(node == null){
            return false;
        }
        
        //add node value to current sum
        currSum += node.val;

        //return true if sum from root to leaf equals target sum, false otherwise
        if(node.left == null && node.right == null){
            return currSum == targetSum;
        }
        
        //recursion, see if there is any root-to-leaf path that returns true
        boolean result = dfs(node.left, targetSum, currSum) || dfs(node.right, targetSum, currSum);
        return result;
    }
}
