package Q_223_RectangleArea;

// https://leetcode.com/problems/rectangle-area/solution/
public class RectangleArea {
    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(computeArea2(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2));
    }

    // Time :  O(1)
    // Space : O(1)
    public static int computeArea2(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // X : A,C,E,G
        // Y : F,H,B,D
        int interArea = partialInterExists(A,C,E,G) && partialInterExists(F,H,B,D) ?
                finalIntersectionArea(A,B,C,D,E,F,G,H) : 0;
        return findArea(A,B,C,D) + findArea(E,F,G,H) - interArea;
    }

    private static boolean partialInterExists(int lowerOne, int upperOne, int lowerTwo, int upperTwo) {
        return upperOne > lowerTwo && upperTwo > lowerOne;
    }

    private static int finalIntersectionArea(int A,int B,int C,int D,int E,int F,int G,int H) {
        return findArea(Math.max(A,E),Math.max(B,F),Math.min(C,G),Math.min(D,H));
    }

    private static int findArea(int xOne,int yOne,int xTwo,int yTwo) {
        return (yTwo - yOne) * (xTwo - xOne);
    }
}
