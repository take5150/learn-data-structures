/*
 * Binary Tree
 * two of bst is same, return true;
 * 
 *    treeA
 * 
 *         10       
 *        /   \     
 *       4     12　 
 *      / \    / \ 　　　
 *     2   5  8   14
 * 
 *    treeB
 * 
 *         10       
 *        /   \     
 *       4     12　 
 *      / \    / \ 　　　
 *     2   5  8   14
 * 
 *  output: true
 * 
 * 解き方：トップダウンでrecurseする。
 * 
 * 
 * 
 * 
 */

package check_same_binary_tree_18;

public class Main{

  
    public static void main(String[] args) {
      
      Main m = new Main();
  
      NodeTree rootA = new NodeTree(10);
      rootA.left = new NodeTree(4);
      rootA.left.left = new NodeTree(2);
      rootA.left.rigth = new NodeTree(5);
      rootA.rigth = new NodeTree(12);
      rootA.rigth.left = new NodeTree(11);
      rootA.rigth.rigth = new NodeTree(14);

      NodeTree rootB = new NodeTree(10);
      rootB.left = new NodeTree(4);
      rootB.left.left = new NodeTree(2);
      rootB.left.rigth = new NodeTree(5);
      rootB.rigth = new NodeTree(12);
      rootB.rigth.left = new NodeTree(11);
      rootB.rigth.rigth = new NodeTree(14);

      System.out.println(m.isSameBST(rootA, rootB));
  
    }
    
    public boolean isSameBST(NodeTree rootA, NodeTree rootB){

      // base case: rootA and rootB is null, return true
      if (rootA == null && rootB == null) return true;
      if (rootA == null || rootB == null) return false;

      // step1: if rootA.val != rootB.val, return false;
      if(rootA.val != rootB.val) return false;
      
      // step2: recurse left subtrees of rootA adn rootB
      //        recurse rigth subtrees of rootA adn rootB
      // step3: return true if both is true;
      return isSameBST(rootA.left, rootB.left) && isSameBST(rootA.rigth, rootB.rigth);

    }
}
