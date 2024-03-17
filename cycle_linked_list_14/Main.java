/*
 * 
 * リストノードがサイクルしているかどうか見分ける
 * 
 * Cyclical LinkedList 
 * head --> 1 -> 2 -> 3 -> 4 -> 3 , return ture
 * head --> 1 -> 2 -> 3 -> 4 -> null , return false
 * 
 * 
 * アンチパターン：
 * 最適化パターン：slow.next, fast.next.nextでループを回すと、slowとfastが同じ位置に来る
 * 
 * 
 */



package cycle_linked_list_14;


public class Main {
  public static void main(String[] args) {
    Main m = new Main();

    // cycle pattern
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = head.next.next;
    System.out.print(m.cycleLinkedList(head));

    // not cycle pattern
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(4);
    System.out.print(m.cycleLinkedList(head2));

  }

  public boolean cycleLinkedList(ListNode head) {

    // corner case: if head.next or head is null return head
    if(head.next == null || head == null) {
      return false;
    }

    // step1: run two pointer, slow(turtle)and fast(rabbit) while(fast.next and fast.next.next is not null)
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // step2: if there is a cycle, 2x speed fast (rabbit) will eventually catch up with 1x speed slow(turtle) pointer
      if(slow == fast) return true;
    }
    return false;
  }
}
