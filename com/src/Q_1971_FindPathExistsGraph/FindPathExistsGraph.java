package Q_1971_FindPathExistsGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathExistsGraph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0, destination = 2;
        validPath(n,edges,source,destination);
    }

    public static HashSet<Integer>[] getAdjList(int n, int[][] edges) {
        HashSet<Integer>[] adj = new HashSet[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        for(int[] edge : edges) {
            adj[edge[1]].add(edge[0]);
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        HashSet<Integer>[] adj = getAdjList(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == destination) {
                return true;
            }

            for (Integer neigbhor : adj[current]) {
                if(!visited[neigbhor]) {
                    visited[neigbhor] = true;
                    queue.offer(neigbhor);
                }
            }
        }

        return false;
    }
}
