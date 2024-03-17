/*
 * 
 * LinkedList
 * head -> 1 -> 2 -> 3 -> 4 -> null
 * return 4 -> 3 -> 2 -> 1 -> null
 * 
 * 
 * 解き方：
 * 
 * 3つのポインタを使用する。
 * prev, current, next 先生によると鍬パターンらしいです。
 * 
 * step1: while curernt is not null , reverse prev adnd current
 * 
 * i = 0
 * nullが先頭なのが大事。
 * null -> 1 -> 2 -> 3 -> 4
 *  |      |    |
 * prev   cur  next
 * 
 * current.next = prev
 * 
 * null <- 1    2 -> 3 -> 4
 *  |      |    |
 * prev   cur  next
 * 
 * 
 * step2: increment pointers
 * 
 * prev = current
 * current = next
 * next = next.next
 * 
 * null <- 1    2 -> 3 -> 4
 *         |    |    |
 *        prev cur  next
 * 
 * 
 * step3: do again step1
 * 
 * 
 * 
 */




package reverese_linkedlist_17;

public class Main {
  

  public static void main(String[] args) {
    Main m = new Main();
    ListNode head = new ListNode(1);
    head.next =  new ListNode(2);
    head.next.next =  new ListNode(3);
    head.next.next.next =  new ListNode(4);
    head = m.reverseLinkedList(head);
    m.showNodeList(head);
  }

  // pre:  1 -> 2 -> 3 -> 4 
  // post: 4 -> 3 -> 2 -> 1 
  public ListNode reverseLinkedList(ListNode head) {

    ListNode prev = null;
    ListNode current = head;
    ListNode next = current.next;
    // step1: while curernt is not null , reverse prev adnd current
    while(current != null){
      current.next = prev;
      // step2: increment pointers
      prev = current;
      current = next;
      if(next != null){
        next = next.next;
      }
    }

    return prev;
  }

  private void showNodeList(ListNode head){

    ListNode current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }
}
