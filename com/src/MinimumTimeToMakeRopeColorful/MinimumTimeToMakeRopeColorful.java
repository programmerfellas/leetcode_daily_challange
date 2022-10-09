package MinimumTimeToMakeRopeColorful;

/*
    1578. Minimum Time to Make Rope Colorful

    https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

    Algorithm
    1. Initalize totalTime, left and right as 0.
    2. Iterate over balloons, for each group of balloons, we record the total removal time as currTotal and the maximum removal time as currMax.
    3. While the balloon indexed at right has the same color as the balloon indexed at left, we update currTotal and currMax, and increment right by 1.
    Otherwise, it means that we have finished iterating this group, we should add the removal time for this group currTotal - currMax to totalTime, and reset left as right.
 */
public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        int[] neededTime = {1,2,3,4,1};
        String colors = "aabaa";
        System.out.println(approach2(colors,neededTime));
    }

    /*
    Algorithm
        1. Initalize totalTime, left and right as 0.
        2. Iterate over balloons, for each group of balloons, we record the total removal time as currTotal and the maximum removal time as currMax.
        3. While the balloon indexed at right has the same color as the balloon indexed at left, we update currTotal and currMax, and increment right by 1.
        Otherwise, it means that we have finished iterating this group, we should add the removal time for this group currTotal - currMax to totalTime, and reset left as right.
     */
    public static int approach1(String colors, int[] neededTime) {
        int totalCost = 0;
        int left = 0, right = 0;

        while (left < neededTime.length && right < neededTime.length) {
            int currTotal = 0;
            int currMax = 0;

            while (right < neededTime.length && colors.charAt(left) == colors.charAt(right)) {
                currTotal += neededTime[right];
                currMax = Math.max(currMax, neededTime[right]);
                right++;
            }

            totalCost += currTotal - currMax;
            left = right;
        }

        return totalCost;
    }

    /* Algorithm
    1. Initalize totalTime, currMaxTime as 0.
    2. During the itertion over balloons, for each balloon i, it has color of colors[i] and removal time neededTime[i].
        If this balloon is the first balloon of a group, we reset currMaxTime as 0.
        Increment totalTime by the smaller one among neededTime[i] and currMaxTime, since we only remove the balloon with a smaller removal time.
    3. Update currMaxTime as the larger one among neededTime[i] and currMaxTime.
        Return totalTime as the minimum removal time.*/

    public static int approach2(String colors, int[] neededTime) {
        // totalTime: total time needed to make rope colorful;
        // currMaxTime: maximum time of a balloon needed.
        int totalTime = 0, currMaxTime = 0;

        // For each balloon in the array:
        for (int i = 0; i < colors.length(); ++i) {
            // If this balloon is the first balloon of a new group
            // set the currMaxTime as 0.
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                currMaxTime = 0;
            }

            // Increment totalTime by the smaller one.
            // Update currMaxTime as the larger one.
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }

        // Return totalTime as the minimum removal time.
        return totalTime;
    }
}
