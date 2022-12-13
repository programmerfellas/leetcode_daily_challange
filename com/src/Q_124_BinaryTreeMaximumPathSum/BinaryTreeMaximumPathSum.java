package Q_124_BinaryTreeMaximumPathSum;

import utitlities.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Integer[] arr = {-10,9,20,null,null,15,7};
        TreeNode root = TreeNode.insertTree(arr);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private static int maxSum;

    // post order traversal of subtree rooted at `root`
    private static int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        int currVal = root.val != null ? root.val : 0;

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + currVal);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + currVal, gainFromRight + currVal);
    }

}
