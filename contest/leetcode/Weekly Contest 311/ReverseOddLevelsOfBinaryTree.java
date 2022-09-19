//O(|V|) time and space complexity, we need to traverse every nodes in the tree

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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return root;
        }
        
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        //to keep track of current level of tree
        int lvl = 0;
        
        while(!s.isEmpty()){
            Stack<TreeNode> temp = new Stack<>();
            lvl++;
          
            //to indicate that we are in odd level and need to add node to arraylist to reverse values
            boolean add = false;
            if(lvl % 2 != 0){
                add = true;
            }
            ArrayList<TreeNode> arrList = new ArrayList<>();
          
            while(!s.isEmpty()){
                //add children of nodes in stack
                TreeNode node = s.pop();
                if(node.left != null){
                    temp.push(node.left);
                    if(add) arrList.add(node.left);
                }
                if(node.right != null){
                    temp.push(node.right);
                    if(add) arrList.add(node.right);
                }
            }
            
            //reverse node values by utilising arraylist (two pointer)
            if(add){
                int left = 0;
                int right = arrList.size()-1;
                while(left < right){
                    int value = arrList.get(left).val;
                    arrList.get(left).val = arrList.get(right).val;
                    arrList.get(right).val = value;
                    left++;
                    right--;
                }
            }
            
            //replace stack with children and continue traversing
            s = temp;
        }
        return root;
    }
}
