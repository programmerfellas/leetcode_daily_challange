package DataStructureSeries.Q_325_MaximumSizeSubarraySumEqualsk;

import java.util.HashMap;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/?envType=study-plan&id=data-structure-iii
public class MaximumSizeSubarraySumEqualsK {

    public static void main(String[] args) {
        int [] nums = {1,-1,5,-2,3};
        int k = 3;
        System.out.println(maxSubArrayLen(nums,k));
    }


    // Time : O(N)
    // Space : O(N)
    public static int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if all of the numbers seen so far sum to k.
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray.
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            // Only add the current prefix_sum index pair to the
            // map if the prefix_sum is not already in the map.
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }

}
