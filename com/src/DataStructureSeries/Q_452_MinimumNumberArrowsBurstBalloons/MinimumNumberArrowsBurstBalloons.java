package DataStructureSeries.Q_452_MinimumNumberArrowsBurstBalloons;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots2(points));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

    public static int findMinArrowShots2(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int end = points[0][1];
        int arrow = 1;

        for(int i = 0; i < points.length; i++) {
            if(points[i][0] > end){
                arrow++;
                end = points[i][1];
            }
        }

        return arrow;
    }
}
