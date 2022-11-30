package Q_2487_RemoveNodesFromLinkedList;

import utitlities.ListNode;

public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        int[] node = {5,2,13,3,8};
        ListNode head = ListNode.insert(node);
        ListNode afterNode = removeNodes(head);
        System.out.println(afterNode);
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head); // reverses the list
        ListNode curr = reversed;
        while(curr.next != null){ // if the nest note has small value remove it else move to the next node
            if(curr.next.val < curr.val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return reverse(reversed);  //reverse the resultant again
    }

    public ListNode removeNodes2(ListNode head) {
        ListNode revNode = reverse(head);
        ListNode curr = revNode;
        ListNode prev = null;
        int maxValue = Integer.MIN_VALUE;
        while (curr != null) {
            if (curr.val < maxValue) {
                prev.next = curr.next;
            } else {
                prev = curr;
                maxValue = Math.max(curr.val, maxValue);
            }
            curr = curr.next;
        }
        return reverse(revNode);
    }
}
