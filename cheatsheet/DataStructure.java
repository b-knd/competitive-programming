//Tree

//classes
//binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val, TreeNode left, TreeNode right){
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
//node that keeps adjacent nodes in a tree
public class Node {
  List<Node> adj = new ArrayList<>();
  int val;
}

//methods
public void addEdge(Node a, Node b){
   if(a == null || b == null){
     return;
   }
   a.adj.add(b);
   b.adj.add(a);
}
/*------------------------------------------------------------------------------------------------------------------------------*/

