package Hard.Q_834_SumOfDistancesTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SumOfDistancesTree {

    public static void main(String[] args) {
        int n = 6; int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        SumOfDistancesTree sumOfDistancesTree = new SumOfDistancesTree();
        sumOfDistancesTree.sumOfDistancesInTree(n, edges);
    }

    private int[] res;
    private int[] count;
    private List<HashSet<Integer>> adj;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.adj = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return res;
    }

    public void postOrder(int root, int pre) {
        for (int child : adj.get(root)) {
            if(child == pre) continue;
            postOrder(child,root);
            count[root] += count[child];
            res[root] += res[child] + count[child];
        }
        count[root]++;
    }

    public void preOrder(int root, int pre) {
        for (int child : adj.get(root)) {
            if(child == pre) continue;
            res[child] = res[root] - count[child] + count.length - count[child];
            preOrder(child,root);
        }
    }
}
