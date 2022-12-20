package Q_1971_FindPathExistsGraph;

import java.util.*;

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


    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        return dfs(graph, seen, source, destination);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int nextNode : graph.get(currNode)) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath3(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.find(source) == uf.find(destination);
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.root[i] = i;
        }
    }
    public int find(int x) {
        if (this.root[x] != x) {
            this.root[x] = find(this.root[x]);
        }
        return this.root[x];
    }
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            // Modify the root of the smaller group as the root of the
            // larger group, also increment the size of the larger group.
            this.root[rootX] = rootY;
            this.rank[rootY] += this.rank[rootX];
        }
    }
}
