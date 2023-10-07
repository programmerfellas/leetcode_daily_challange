package Q_540_SingleElementInSortedArray;

import java.util.HashMap;
import java.util.Map;

public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        for (Map.Entry<Integer,Integer> set : map.entrySet()) {
            if(set.getValue() < 2) {
                return set.getKey();
            }
        }
        return 0;
    }

    public static int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate2(nums));
    }
}
