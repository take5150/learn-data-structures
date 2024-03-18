/*
 * Binary Tree
 * find lowest common anscester in bst,
 * for example, target=[1,5] lowest common anscester is four!
 * 
 *         10       
 *        /   \     
 *      (4)     12　 
 *      / \    / \ 　　　
 *     2   5  8   14
 *    /
 *   1
 * 
 * for example, target=[1,2] lowest common anscester is four!
 * 
 *         10       
 *        /   \     
 *      (4)     12　 
 *      / \    / \ 　　　
 *     2   5  11   14
 *    /
 *   1
 * 
 * 
 */

package Lowest_common_anscestor_bst_20;

public class Main{

  
    public static void main(String[] args) {
      
      Main m = new Main();
  
      NodeTree root = new NodeTree(10);
      root.left = new NodeTree(4);
      root.left.left = new NodeTree(2);
      root.left.left.left = new NodeTree(1);
      root.left.rigth = new NodeTree(5);

      root.rigth = new NodeTree(12);
      root.rigth.left = new NodeTree(11);
      root.rigth.rigth = new NodeTree(14);

      System.out.println(m.findLowerCommonAnscester(root, root.left.left, root.left.left.left ).val);
  
    }
    
    public NodeTree findLowerCommonAnscester(NodeTree root, NodeTree p, NodeTree q){

      // base case: if root.val is p.val or q.val, then root is LCA so return root
      if (root.val == p.val || root.val == q.val) return root;

      // step1: if min(p.val, q.val) < root.val < max(p.val, q.val) then root is LCA as well
      if (Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) return root;

      // step2: if max(p.val, q.val) < root.val, recurse left subtree
      if (Math.max(q.val, q.val) < root.val){
        return findLowerCommonAnscester(root.left, p, q);
      // step3: if max(p.val, q.val) > root.val, recurse rigth subtree
      }else return findLowerCommonAnscester(root.rigth, p, q);
    }

}
