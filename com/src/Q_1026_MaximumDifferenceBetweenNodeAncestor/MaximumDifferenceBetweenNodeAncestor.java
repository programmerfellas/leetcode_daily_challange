package Q_1026_MaximumDifferenceBetweenNodeAncestor;

import utitlities.TreeNode;

public class MaximumDifferenceBetweenNodeAncestor {

    public static void main(String[] args) {

    }

    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }
        result = 0;
        helper(root, root.val, root.val);
        return result;
    }

    private void helper(TreeNode root, int maxVal, int minVal) {
        if(root == null) {
            return;
        }

        int possibleResult = Math.max(Math.abs(maxVal - root.val),Math.abs(minVal - root.val));
        result = Math.max(result,possibleResult);

        maxVal = Math.max(maxVal,root.val);
        minVal = Math.min(minVal,root.val);
        helper(root.left, maxVal, minVal);
        helper(root.right, maxVal, minVal);
        return;
    }


    public int maxAncestorDiff2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper2(root, root.val, root.val);
    }

    public int helper2(TreeNode node, int curMax, int curMin) {
        // if encounter leaves, return the max-min along the path
        if (node == null) {
            return curMax - curMin;
        }
        // else, update max and min
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper2(node.left, curMax, curMin);
        int right = helper2(node.right, curMax, curMin);
        return Math.max(left, right);
    }
}
