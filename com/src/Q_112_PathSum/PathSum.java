/*
    112. Path Sum
 */
package Q_112_PathSum;


import utitlities.TreeNode;

public class PathSum {
    public static void main(String[] args) {
//        int[] root = {1,2,3};
        int targetSum = 5;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        hasPathSum(root,targetSum);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return (targetSum == 0);
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
