package Q_2500_DeleteGreatestValueEachRow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DeleteGreatestValueEachRow {

    public static void main(String[] args) {
        int[][] grid = {{1,2,4},{3,3,1}};
        System.out.println(deleteGreatestValue2(grid));
    }

    public static int deleteGreatestValue(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int ans = 0;
        for(int col = 0; col < grid[0].length; col++) {
            int max = 0;
            for(int row = 0; row < grid.length; row++) {
                max = Math.max(max, grid[row][col]);
            }
            ans += max;
        }
        return ans;
    }

    public static int deleteGreatestValue2(int[][] grid) {
        boolean status = true;
        int sum=0;
        while(status) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<grid.length;i++) {
                int maxInRow = 0;
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j] > grid[i][maxInRow]) maxInRow = j;
                }
                pq.add(grid[i][maxInRow]);
                grid[i][maxInRow] = 0;
            }
            if(pq.peek() == 0) break;
            sum += pq.peek();
        }
        return sum;
    }
}
