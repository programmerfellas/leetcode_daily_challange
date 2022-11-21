package Q_1926_NearestExitFromEntranceMaze;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceMaze {

    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(nearestExit2(maze,entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Mark the entrance as visited since its not a exit.
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';

        // Start BFS from the entrance, and use a queue `queue` to store all
        // the cells to be visited.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

            // For the current cell, check its four neighbor cells.
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                // If there exists an unvisited empty neighbor:
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {

                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;

                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }
            }
        }

        // If we finish iterating without finding an exit, return -1.
        return -1;
    }


    private static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int nearestExit2(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        int steps = 1;
        int startRow = entrance[0], startCol = entrance[1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = q.poll();
                for (int[] dir : DIRS) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (insideMaze(row, col, m, n) && maze[row][col] == '.' && !visited[row][col]) {
                        if (!(row == startRow && col == startCol) && isOnBorder(row, col, m, n))
                            return steps;
                        visited[row][col] = true;
                        q.offer(new int[] { row, col });
                    }
                }
            }
            ++steps;
        }

        return -1;
    }

    private static boolean insideMaze(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    private static boolean isOnBorder(int row, int col, int m, int n) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }
}
