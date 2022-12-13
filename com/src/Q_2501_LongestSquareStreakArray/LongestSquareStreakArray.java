package Q_2501_LongestSquareStreakArray;

import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakArray {

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }

    public static int longestSquareStreak(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 1;
            while(set.contains(num * num)) {
                num = num * num;
                count++;
            }

            if(count > 1) max = Math.max(count,max);
        }
        return max == 0 ? -1 : max;
    }
}
