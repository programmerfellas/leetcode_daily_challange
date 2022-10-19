package DeleteNodeLinkedList;

import utitlities.ListNode;

public class DeleteNodeLinkedList {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        // Since we know input node is not last node, so nextNode will not be null
        ListNode nextNode = node.next;

        //Step 2
        node.val = nextNode.val;

        // Step 3
        node.next = nextNode.next;
        nextNode.next = null;

    }

}
