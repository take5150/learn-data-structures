/*
 * Binary Tree
 * if target is five, then return five`s node
 * if target is seven, there is not seven node, then return root(10)
 *         10
 *        /   \
 *       4     12
 *      / \    / \ 
 *     2   5  8   14
 * 
 * base case : if root is null, return null
 * 
 * best case : root.val = val return root
 * 
 * step1: target < root.val then search to root.left
 *        if(target < root.val) searchBST(root.left, target)
 * 
 *        else searchBST(root.right, target)
 * 
 * step2: if root.left.val or root.right.val equals target, return root.left or right
 * 
 * ランタイム：O(N)
 * スペース：O(N) RecursiveでfunctionをCSにためる際にメモリをアロケートする。
 * 　　　　　　　　何回再帰するか？Nのサイズだけ再帰するためO(N)使用する
 * 
 */




package binary_search_tree_find_node_19;

public class Main{

  
  
  public static void main(String[] args) {
    
    Main m = new Main();

    NodeTree root = new NodeTree(10);
    root.left = new NodeTree(4);
    root.left.left = new NodeTree(2);
    root.left.rigth = new NodeTree(5);
    
    root.rigth = new NodeTree(12);
    root.rigth.left = new NodeTree(11);
    root.rigth.rigth = new NodeTree(14);

    
    
    // *testcase1: target=4
    // *         10
    // *        /   \
    // *       4     12
    // *      / \    / \ 
    // *     2   5  11   14
    // System.out.println(m.searchBST(root, 4).val);
    
    // *testcase2: target=2
    // *         10
    // *        /   \
    // *       4     12
    // *      / \    / \ 
    // *     2   5  11   14
    // System.out.println(m.searchBST(root, 2).val);
    
    // *testcase3: target=5
    // *         10
    // *        /   \
    // *       4     12
    // *      / \    / \ 
    // *     2   5  11   14
    
    // *testcase4: target=11
    // *         10
    // *        /   \
    // *       4     12
    // *      / \    / \ 
    // *     2   5  11  14
    // System.out.println(m.searchBST(root, 11).val);
    
    // *testcase4: target=100 return null
    // *         10
    // *        /   \
    // *       4     12
    // *      / \    / \ 
    // *     2   5  11  14
    NodeTree resultNode = m.searchBST(root, 100);
    System.out.println((resultNode != null) ? resultNode.val : "対象ノードは存在しません。" );

  }
  
  public NodeTree searchBST(NodeTree root, int target){
    
    // base case : if root is null, return null
      if (root == null) return root;

      // best case : root.val = val return root
      if (root.val == target) return root;

      // step1: target < root.val then search to root.left
      if (target < root.val) return searchBST(root.left, target);
      else return searchBST(root.rigth, target);
      
  }

}