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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arrList = new ArrayList<>();
        return recurse(arrList, root, k);
    }

    public boolean recurse(ArrayList<Integer> arrList, TreeNode node, int k){
     
        if(node == null){
            return false;
        }
      
        int complement = k - node.val;
      
        //if complement did exist, return true otherwise add to arraylist and continue traversing
        if(arrList.contains(complement)){
            return true;
        }
        arrList.add(node.val);

        return recurse(arrList, node.left, k) || recurse(arrList, node.right, k);
    }
}
