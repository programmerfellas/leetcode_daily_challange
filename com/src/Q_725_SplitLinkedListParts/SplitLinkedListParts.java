package Q_725_SplitLinkedListParts;

import utitlities.ListNode;

public class SplitLinkedListParts {

    public static void main(String[] args) {
        int[] listArr = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        ListNode head = ListNode.insert(listArr);
        ListNode[] listOfNode = splitListToParts(head,k);
        System.out.println(listOfNode);
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}
