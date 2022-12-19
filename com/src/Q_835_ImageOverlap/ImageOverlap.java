package Q_835_ImageOverlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {

    public static void main(String[] args) {
        int [][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
        int [][] img2 = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(largestOverlap(img1,img2));
    }

    private static int shift_count(int[][] A, int[][] B){
        int n = A.length, count = 0;
        for(int x = 0; x < n; ++x){
            for(int y = 0; y < n; ++y){
                int temp = 0;
                for(int i = y; i < n; ++i){
                    for(int j = x; j < n; ++j)
                        if(A[i][j] == 1 && B[i-y][j-x] == 1) temp++;
                }
                count = Math.max(count, temp);
            }
        }
        return count;
    }
    public static int largestOverlap(int[][] A, int[][] B) {
        return Math.max(shift_count(A, B), shift_count(B, A));
    }

    /**
     *  Shift the matrix M in up-left and up-right directions
     *    and count the ones in the overlapping zone.
     */
    protected static int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public static int largestOverlap2(int[][] img1, int[][] img2) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < img1.length; ++yShift)
            for (int xShift = 0; xShift < img1.length; ++xShift) {
                // move the matrix A to the up-right and up-left directions.
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, img1, img2));
                // move the matrix B to the up-right and up-left directions, which is equivalent to moving A to the down-right and down-left directions
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, img2, img1));
            }

        return maxOverlaps;
    }


}
