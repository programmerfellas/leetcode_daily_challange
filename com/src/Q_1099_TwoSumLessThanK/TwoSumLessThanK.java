package Q_1099_TwoSumLessThanK;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static void main(String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        int k = 60;
        System.out.println(twoSumLessThanK(nums,k));
    }

//    O(n log n)
    public static int twoSumLessThanK(int[] nums,int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;
        while(left < right) {
            int sum = nums[right] + nums[left];
            if(sum < k) {
                answer = Math.max(answer,sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

//    O(n2)
    public int twoSumLessThanK2(int[] nums, int k) {
        int answer = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) {
                    answer = Math.max(answer, sum);
                }
            }
        }
        return answer;
    }
}
