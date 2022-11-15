package Q_222_CountCompleteTreeNodes;

import utitlities.TreeNode;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        System.out.println(countNodes(node));
    }

    static int count = 0;
    public static int countNodes(TreeNode root) {
        if(root != null) {
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return count;
    }
}
