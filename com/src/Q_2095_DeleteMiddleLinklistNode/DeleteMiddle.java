package Q_2095_DeleteMiddleLinklistNode;

import utitlities.ListNode;

public class DeleteMiddle {

    public static void main(String[] args) {
        int[] node = {1,3,4,7,1,2,6};
        ListNode head = ListNode.insert(node);

        System.out.println(deleteMiddle(head));
    }


    public static ListNode deleteMiddle(ListNode head) {
        // Edge case: return nullptr if there is only one node.
        if (head.next == null)
            return null;

        // Initialize two pointers, 'slow' and 'fast'.
        ListNode slow = head, fast = head.next.next;

        // Let 'fast' move forward by 2 nodes, 'slow' move forward by 1 node each step.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When 'fast' reaches the end, remove the next node of 'slow' and return 'head'.
        slow.next = slow.next.next;
        return head;
    }


}
