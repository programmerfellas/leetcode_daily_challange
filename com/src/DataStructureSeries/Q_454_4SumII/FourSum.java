package DataStructureSeries.Q_454_4SumII;

import java.util.HashMap;
import java.util.Map;

public class FourSum {

    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                cnt += m.getOrDefault(-(c + d), 0);
            }
        }
        return cnt;
    }
}
