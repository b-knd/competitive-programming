//O(N) time complexity: breadth first search
//O(N) space complexity

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Queue<Node> temp = new LinkedList<>();
            List<Integer> lst = new ArrayList<>();
            
            while(!q.isEmpty()){
                Node node = q.poll();
                lst.add(node.val);
                for(Node n: node.children){
                    temp.add(n);
                }
            }
            res.add(new ArrayList<>(lst));
            q = temp;
        }
        return res;
    }
}
