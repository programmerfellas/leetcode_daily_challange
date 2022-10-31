package ShortestPathGridWithObstaclesElimination;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGridWithObstaclesElimination {

    public static void main(String[] args) {

    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();
        int steps = 0;
        q.offer(new int[]{0,0,k});

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                // If curr is the destination return false
                if(curr[0] == m-1 && curr[1] == n-1) {
                    return steps;
                }
                // ELSE go in all valid directions
                vaildGrid(DIR,curr,q,visited,grid,n,m);
            }
            ++steps;
        }
        return -1;
    }

    private static void vaildGrid(int[][] DIR, int[] curr,Queue<int[]> q,
                           boolean[][][] v,int[][] grid,int n, int m) {
        for(int[] d : DIR) {
            int i = curr[0] + d[0];
            int j = curr[1] + d[1];
            int obs = curr[2];
            // Traverse through the valid cells
            if (i >= 0 && i < m && j >= 0 && j < n) {
                // If cell is empty visit the cell and add in queue
                if (grid[i][j] == 0 && !v[i][j][obs]) {
                    q.offer(new int[]{i, j, obs});
                    v[i][j][obs] = true;
                } else if (grid[i][j] == 1 && obs > 0 && !v[i][j][obs - 1]) {
                    q.offer(new int[]{i, j, obs - 1});
                    v[i][j][obs - 1] = true;
                }
            }
        }
    }
}
