package Q_328_OddEvenLinkedList;

import utitlities.ListNode;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        int[] listArr = {2,1,3,5,6,4,7};
        ListNode head = ListNode.insert(listArr);
        oddEvenList(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null ) return head;
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // Combine even list after odd node
        odd.next = evenHead;
        return head;

    }

}
