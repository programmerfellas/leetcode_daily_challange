package DataStructureSeries.Q_1151_MinimumSwapsGroupAll1Together;

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/?envType=study-plan&id=data-structure-iii

import java.util.Arrays;

public class MinimumSwapsGroupAll1Together {

    public static void main(String[] args) {
        int[] data = {1,0,1,0,1};
        System.out.println(minSwaps(data));
    }

    // Time : O(N)
    // Space : O(1)
    public static int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            // updating the number of 1's by adding the new element
            cnt_one += data[right++];
            // maintain the length of the window to ones
            if (right - left > ones) {
                // updating the number of 1's by removing the oldest element
                cnt_one -= data[left++];
            }
            // record the maximum number of 1's in the window
            max_one = Math.max(max_one, cnt_one);
        }
        return ones - max_one;
    }

}
