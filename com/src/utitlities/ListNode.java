package utitlities;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }

      public ListNode() {
      }

      public static ListNode insert(int[] arr) {
            ListNode root = null;
            int n = arr.length;
            for (int i = n - 1; i >= 0 ; i--) {
                  ListNode temp = new ListNode();
                  temp.val = arr[i];
                  temp.next = root;
                  root = temp;
            }
            return root;
      }
}
