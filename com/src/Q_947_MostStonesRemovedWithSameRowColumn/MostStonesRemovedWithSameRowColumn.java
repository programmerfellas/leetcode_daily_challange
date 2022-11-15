package Q_947_MostStonesRemovedWithSameRowColumn;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedWithSameRowColumn {


    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    /*
         |0  |1  |2
       0 |ST |ST |
       1 |ST |   |ST
       2 |   |ST |ST

    */
        System.out.println(removeStones(stones));
    }


    static void dfs(List<Integer>[] adj, boolean[] visited, int src) {
        // Mark the stone as visited
        visited[src] = true;

        // Iterate over the adjacent, and iterate over it if not visited yet
        for (int adjacent : adj[src]) {
            if (!visited[adjacent]) {
                dfs(adj, visited, adjacent);
            }
        }
    }

    static int removeStones(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = createAdjList(stones);

        // Array to mark visited stones
        boolean[] visited = new boolean[stones.length];

        // Counter for connected components
        int componentCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                // If the stone is not visited yet,Start the DFS and increment the counter
                componentCount++;
                dfs(adj, visited, i);
            }
        }

        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }

    public static List<Integer>[] createAdjList(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = new ArrayList[stones.length];
        for (int i = 0; i < stones.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                // Return true if stone a and b shares row or column
                if (stones[0] == stones[0] || stones[1] == stones[1]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        return adj;
    }

}
