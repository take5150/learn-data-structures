/*
 * Binary Tree
 * if trees is symmetric, return ture
 * 
 *    tree
 * 
 *         10       
 *        /   \     
 *       4      4　 
 *      / \    /  \ 　　　
 *     2   5  5    2
 * 
 *    tree'
 * 
 *         10       
 *        /   \     
 *      4 　    4   
 *     /  \    / \　　    　　　
 *    5    2 　2　 5 
 * 
 *  output: true
 * 
 * 解き方:両ツリーでトップダウンで再帰処理を行う
 * 
 * 
 */

package symmetric_binary_tree_19;

public class Main{

  
    public static void main(String[] args) {
      
      Main m = new Main();
  
      // NodeTree rootA = new NodeTree(10);
      // rootA.left = new NodeTree(4);
      // rootA.left.left = new NodeTree(2);
      // rootA.left.rigth = new NodeTree(5);
      // rootA.rigth = new NodeTree(4);
      // rootA.rigth.left = new NodeTree(5);
      // rootA.rigth.rigth = new NodeTree(2);

      NodeTree rootA = new NodeTree(10);
      rootA.left = new NodeTree(4);
      rootA.rigth = new NodeTree(4);
      rootA.rigth.left = new NodeTree(5);

      // NodeTree rootB = new NodeTree(10);
      // rootB.left = new NodeTree(12);
      // rootB.left.left = new NodeTree(14);
      // rootB.left.rigth = new NodeTree(11);
      // rootB.rigth = new NodeTree(4);
      // rootB.rigth.left = new NodeTree(2);

      System.out.println(m.isSynmetricBST(rootA));
      // System.out.println(m.isSynmetricBST(rootB));
  
    }
    
    public boolean isSynmetricBST(NodeTree root){

      // base case: if rootB is null, return ture
      if (root == null) return true;

      // if left and rigth subrees is null , return true
      if(root.left == null && root.rigth == null) return true;

      // if left or rigth subtrees is null , return false
      if(root.left == null || root.rigth == null) return false;
      
      // if roots left and roots rigth is not same, return false;
      if (root.left.val != root.rigth.val) return false;
      
      return isSynmetricBSTHelper(root.left, root.rigth);

    }

    private boolean isSynmetricBSTHelper(NodeTree left, NodeTree right){

      // base case: if both are null , return ture
      if(left == null && right == null) return true;

      // step1: check if left.left.val == right.rigth.val, return ture
      if((left.left != null && right.rigth != null) && left.left.val != right.rigth.val) return false;

      // step2: check if left.rigth.val == rigth.left.val, return false
      if((left.rigth != null && right.left != null) && left.rigth.val != right.left.val) return false;

      // step3: recurse here isSymmetricHeloer(left.left, left.rigth)
      return isSynmetricBSTHelper(left.left, right.rigth) && isSynmetricBSTHelper(left.rigth, right.left);

    }
}
