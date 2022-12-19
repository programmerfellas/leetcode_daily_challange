package Q_669_TrimBinarySearchTree;

import utitlities.TreeNode;

public class TrimBinarySearchTree {

    public static void main(String[] args) {
        Integer[] arr = {3,0,4,null,2,null,null,1};
        int low = 1, high = 3;
        TreeNode root = TreeNode.insertTree(arr);
        TreeNode res = trimBST(root, low, high);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        } else if (root.val != null && root.val < low) {
            return trimBST(root.right,low,high);
        } else if (root.val != null && root.val > high) {
            return trimBST(root.left,low,high);
        } else {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
    }
}
