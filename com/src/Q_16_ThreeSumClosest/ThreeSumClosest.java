package Q_16_ThreeSumClosest;

// 16. 3Sum Closest

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[]  arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < size && diff != 0; ++i) {
            int start = i+1;
            int end = size -1;

            while(start < end) {
                System.out.println("first = " + i +", Start = "+start + ", End = "+end);

                int sum = nums[i] + nums[start] + nums[end];
                System.out.println("Sum = "+nums[i] + "+"+nums[start] + "+" + nums[end] + " = "+sum);
                if(Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                System.out.println(Math.abs(target - sum) + " (target - sum) < (diff) "+Math.abs(diff) + " = diff  = " + diff);

                if(sum < target) {
                    ++start;
                    System.out.println(sum + " < " + target + " (sum < target ) - increment start "+ start);
                } else {
                    --end;
                    System.out.println(sum + " > " + target + " (sum > target ) decrement start "+ end);
                }

                System.out.println("=================================================");
            }
        }
        System.out.println("Result = "+target+"-"+diff);
        return target - diff;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < size && diff != 0; ++i) {
            int start = i + 1;
            int end = size -1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == target) {
                    return target;
                }else if(Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                    ans = sum;
                }

                if(sum < target) ++start;
                else --end;

            }
        }
        return ans;
    }

}
