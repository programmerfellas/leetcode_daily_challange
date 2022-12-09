package Q_938_RangeSumBST;

import utitlities.TreeNode;

import java.util.Stack;

public class RangeSumBST {

    public static void main(String[] args) {

    }

    int rangeSum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        if(root.val >= low && root.val <= high) {
            rangeSum += root.val;
        }

        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return rangeSum;
    }

    int ans;
    public int rangeSumBST2(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                ans += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }

    public int rangeSumBST3(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    ans += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
