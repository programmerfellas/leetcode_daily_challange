package Q_872_LeafSimilarTrees;

import utitlities.TreeNode;

import java.util.*;

public class LeafSimilarTrees {

    private static List<Integer> leafList = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstNode = new ArrayList<>();
        leafValue(root1,firstNode);
        List<Integer> secondNode =  new ArrayList<>();
        leafValue(root2,secondNode);
        return firstNode.equals(secondNode);
    }

    private static void leafValue(TreeNode root,List<Integer> node){
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            node.add(root.val);

        leafValue(root.left,node);
        leafValue(root.right,node);
    }

    public static void preOrderTraversal(TreeNode root,List<Integer> list){
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            list.add(root.val);

        preOrderTraversal(root.left,list);
        preOrderTraversal(root.right,list);

    }
}
