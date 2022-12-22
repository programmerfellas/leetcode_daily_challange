package Meduim.Q_2497_MaximumStarSumGraph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumStarSumGraph {

    public static void main(String[] args) {
        int[] vals = {1,2,3,4,10,-10,-20};
        int[][] edges = {{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}};
        int k = 2;
        maxStarSum(vals,edges,k);
    }

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], node -> new PriorityQueue<>(Comparator.reverseOrder())).add(vals[edge[1]]);
            graph.computeIfAbsent(edge[1], node -> new PriorityQueue<>(Comparator.reverseOrder())).add(vals[edge[0]]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            int currSum = vals[i];
            PriorityQueue<Integer> pq = graph.getOrDefault(i, new PriorityQueue<>());
            for (int j = 0; j < k && !pq.isEmpty(); j++){
                currSum += Math.max(pq.poll(), 0);
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
