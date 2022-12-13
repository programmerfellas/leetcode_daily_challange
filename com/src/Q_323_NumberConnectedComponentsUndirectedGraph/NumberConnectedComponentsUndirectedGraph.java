package Q_323_NumberConnectedComponentsUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class NumberConnectedComponentsUndirectedGraph {

    public static void main(String[] args) {

    }

    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        List<List<Integer>> adjList = adjList(n,edges);
        int componentCount = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                componentCount++;
                dfs(adjList,visited,i);
            }
        }
        return componentCount;
    }

    public static void dfs(List<List<Integer>> adjList, boolean visited[], int startNode) {
        visited[startNode] = true;

        for(Integer neigbhour : adjList.get(startNode)) {
            if(!visited[neigbhour]) {
                dfs(adjList,visited,neigbhour);
            }
        }
    }

    public static List<List<Integer>> adjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int edge[] : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
