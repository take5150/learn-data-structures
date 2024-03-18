/*
 * 
 * LinkedList
 * head -> 1 -> 1 -> 1 -> 2
 * return 1 -> 2
 * 
 * 
 * アンチパターン：ネストループを使用する
 * 最適パターン：カレントノード、カレントノードの次のノードを比較する。
 * 
 * 
 * step1: list is sorted, so list loop while(current.next != null)
 * if(current.val == current.next.val) current.next = current.next.next -> not current increment
 * 
 * step:2 if current.val != current.next.val current = current.next
 * 
 * 
 * 
 */




package delete_node_from_sorted_linkedlist_14;

public class Main {
  

  public static void main(String[] args) {
    Main m = new Main();
    ListNode head = new ListNode(1);
    head.next =  new ListNode(1);
    head.next.next =  new ListNode(1);
    head.next.next.next =  new ListNode(2);
    m.deleteDupNode(head);
    m.showNodeList(head);
  }

  // pre: 1->1->1->2
  // post:1->2
  public ListNode deleteDupNode(ListNode head) {

    // step1: list is sorted, so list loop while(current.next != null)
    ListNode current = head;
    while(current.next != null){
      if(current.val == current.next.val) {
        current.next = current.next.next;
      }else{
        current = current.next;
      }
    }
    return head;

  }

  private void showNodeList(ListNode head){

    ListNode current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }
}
