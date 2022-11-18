package DataStructureSeries.Q_448_FindAllNumbersDisappearedArray;

import java.util.*;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?envType=study-plan&id=data-structure-iii
public class FindAllNumbersDisappearedArray {

    public static void main(String[] args) {
       int[] nums = {4,3,2,7,8,2,3,1};
       System.out.println(findDisappearedNumbers3(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        for(int i = 1; i < n+1; i++) {
            if(!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for(int i = 1; i < n+1; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }


    public static List<Integer> findDisappearedNumbers3(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
