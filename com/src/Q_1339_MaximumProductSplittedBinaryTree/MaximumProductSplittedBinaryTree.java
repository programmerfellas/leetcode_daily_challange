package Q_1339_MaximumProductSplittedBinaryTree;

import utitlities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSplittedBinaryTree {

    public static void main(String[] args) {
        MaximumProductSplittedBinaryTree maximumProductSplittedBinaryTree = new MaximumProductSplittedBinaryTree();
        Integer[] arr = {1,null,2,3,4,null,null,5,6}; //{1,2,3,4,5,6};
        TreeNode root = TreeNode.insertTree(arr);
        int totalSum = maximumProductSplittedBinaryTree.maxProduct(root);
    }

    private List<Integer> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        // long is a 64-bit integer.
        long totalSum = treeSum(root);
        long best = 0;
        for (long sum : allSums) {
            best = Math.max(best, sum * (totalSum - sum));
        }
        // We have to cast back to an int to match return value.
        return (int)(best % 1000000007);

    }

    private Integer treeSum(TreeNode subroot) {
        if (subroot == null) return 0;
        Integer leftSum = treeSum(subroot.left);
        Integer rightSum = treeSum(subroot.right);
        Integer totalSum = leftSum + rightSum + (subroot.val != null ? subroot.val : 0);
        allSums.add(totalSum);
        return totalSum;
    }
}
