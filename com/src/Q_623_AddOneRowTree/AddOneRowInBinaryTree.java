package Q_623_AddOneRowTree;

import utitlities.TreeNode;

import java.util.Stack;
class Node {
    int depth;
    TreeNode node;
    Node(TreeNode node,int depth) {
        this.depth = depth;
        this.node = node;
    }
}
public class AddOneRowInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        int val = 1, depth = 2;
        TreeNode finalNode = approach1(root,val,depth);
        System.out.println(finalNode);
    }

    public static TreeNode approach1(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode t = new TreeNode(val);
            t.left = t;
            return t;
        }
        return insert(val,1,depth,root);
    }

    public static TreeNode insert(int val, int curr,int n, TreeNode root) {
        if (root == null) return root;
        if (curr == n-1) {
            TreeNode t = root.left;
            root.left = new TreeNode(val);
            root.left.left = t;
            t = root.right;
            root.right = new TreeNode(val);
            root.right.right = t;
        } else {
            insert(val,curr+1,n,root.left);
            insert(val,curr+1,n,root.right);
        }
        return root;
    }

    // Approach #2 Using stack(DFS) [Accepted]
    public static TreeNode approach2(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root,1));
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            if (currNode == null) continue;
            if(currNode.depth == depth-1) {
                TreeNode t = currNode.node.left;
                currNode.node.left = new TreeNode(val);
                currNode.node.left.left = t;

                t = currNode.node.right;
                currNode.node.right = new TreeNode(val);
                currNode.node.right.right = t;
            } else {
                stack.push(new Node(currNode.node.left,currNode.depth+1 ));
                stack.push(new Node(currNode.node.right,currNode.depth+1 ));
            }
        }
        return root;
    }

}
