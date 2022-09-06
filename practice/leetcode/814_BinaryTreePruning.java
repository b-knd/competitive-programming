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
    public TreeNode pruneTree(TreeNode root) {
         if(checkNode(root)){
             return root;
         } else{
             return null;
         }
    }
    
    
    //given node, we check left and right: remove false child nodes
    //if both nodes = false (being removed and now null): root node return based on value
    //else return true
    public boolean checkNode(TreeNode node){
        if(node == null){
            return true;
        }
        //both children are false and need to be removed
        if(!checkNode(node.left)){
            node.left = null;
        }
        if(!checkNode(node.right)){
            node.right = null;
        }
        
        //does not have children anymore (node itself determine the result)
        if(node.left == null && node.right == null){
            return node.val == 1? true: false;
        }
        
        //one or both children exist (true)
        return true;
    }
}
