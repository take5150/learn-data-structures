/*
 * LinkedListのミドルノードを返す
 * 
 * アンチパターン：1回目のループでlistのカウントを数える。2回目のループで真ん中のノードで終了させてreturn
 * 最適パターン：進みが遅いインデックス、早いインデックスを使って1回のループで終わらせる
 * 
 * 
 * step1: ノードの個数が偶数、奇数の場合のケースを考える
 * odd pattern -- head --> 1 --> 3 --> 5 => return 3
 * even pattern -- head --> 2 --> 4 --> 6 => return 4
 * 
 * step2: slow,fastをfast.next or fast.next.nextがnullになるまでループをする
 * 
 * step3: odd case, even case reutrn middle
 * 
 * odd case : if fast.next is null return slow is middle
 * even case: if fast.next.next is null return slow.next
 * 
 * 
 */




package midle_node_in_linked_list_11;

public class Main{
  public static void main(String[] args) {
    Main m = new Main();

    // odd case
    // ListNode head = new ListNode(1);
    // head.next = new ListNode(2);
    // head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);

    // even case
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    System.out.print(m.middleNode(head).val);
  }

  public ListNode middleNode(ListNode head) {

    // corner case: if head or head.next is null , return head
    if(head == null || head.next == null) return head;

    ListNode slow = head;
    ListNode fast = head;

    // slow,fastをfast.next or fast.next.nextがnullになるまでループをする
    while(fast.next != null && fast.next.next != null) {
      // odd case
      // testcase1: slow = 1; fast = 1;
      // testcase2: slow = 2; fast = 3;
      // testcase3: slow = 3; fast = 5;

      // even case
      // testcase1: slow = 1; fast = 1;
      // testcase2: slow = 2; fast = 3;
      slow = slow.next;
      fast = fast.next.next;
    }

    // odd case, even case reutrn middle
    ListNode middle;
    if(fast.next == null) {
      middle = slow;
    }else {
      middle = slow.next;
    }

    return middle;

  }

}

