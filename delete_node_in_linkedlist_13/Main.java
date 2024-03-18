/*
 *
 * linkedlist is (head -> 1 -> 2 -> 3 -> 4)
 * delete 2 then (head -> 1 -> 3 -> 4)
 * 
 * 
 * アンチパターン：
 * 最適パターン：削除するノードにたどり着いたら、削除するノードを隣のノードで上書きする。
 * 
 * step1: check if node is tail then do nothing,
 * 
 * 
 * step2: node is non-tail , rebember node.next.
 *        for example delete 2, rember 3, update 2 to 3,
 *        then updated 3(before 2) link 4(skip 3(original))
 *        head -> 1 -> 2 -> 3 -> 4
 * 
 * 
 *  
 * 
 * 
 */


package delete_node_in_linkedlist_13;

public class Main {


  public ListNode deleteTargetNode(ListNode node) {

    //  check if node is tail then do nothing
    if (node.next == null) return node;

    // node is non-tail , rebember node.next.next
    ListNode nodeNextNext = node.next.next;

    // set node.next value to node.val
    node.val = node.next.val;

    // set node.next link nodeNextNext
    node.next = nodeNextNext;

    return node;

    
  }
  
}
