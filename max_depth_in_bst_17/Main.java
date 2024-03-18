/*
 * Binary Tree
 * return binary search tree depth (ex: 4)
 * 
 *         10        | 1
 *        /   \     
 *       4     12　  | 2　　
 *      / \    / \ 　　　
 *     2   5  8   14 | 3　
 *    /
 *   1               | 4
 * 
 * 解き方：再帰を使って深さをチェックする。ボトムアップソリューション 
 * 　　　　最初に下まで行ってから上がっていく
 * 
 * 
 * 
 */




package max_depth_in_bst_17;

public class Main{

  
    public static void main(String[] args) {
      
      Main m = new Main();
  
      NodeTree root = new NodeTree(10);
      root.left = new NodeTree(4);
      root.left.left = new NodeTree(2);
      root.left.rigth = new NodeTree(5);
      root.left.left.left = new NodeTree(1);
      
      root.rigth = new NodeTree(12);
      root.rigth.left = new NodeTree(11);
      root.rigth.rigth = new NodeTree(14);
  
      
      // * testcase1
      // *         10        | 1
      // *        /   \     
      // *       4     12　  | 2　　
      // *      / \    / \ 　　　
      // *     2   5  8   14 | 3　
      // *    /
      // *   1               | 4
      // * 
  
      System.out.println(m.maxDepthBST(root));
  
    }
    
    public int maxDepthBST(NodeTree root){
  
      // basecase : if root is null then return 0
      if (root == null) return 0;
  
      // step1: recurse left subtree and get
      int maxDepthLeft = maxDepthBST(root.left);
      
      // step2: recurse fight subtree and get
      int maxDepthRight = maxDepthBST(root.rigth);
      
      // step3: return max depth
      return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }
  
}
