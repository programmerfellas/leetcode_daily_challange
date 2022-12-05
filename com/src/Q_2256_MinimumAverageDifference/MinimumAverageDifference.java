package Q_2256_MinimumAverageDifference;

public class MinimumAverageDifference {

    public static void main(String[] args) {
        int[] nums = {2,5,3,9,5,3};
        System.out.println(minimumAverageDifference(nums));
    }

    public static int minimumAverageDifference(int[] nums) {
        long totalSum = 0,leftSum = 0,rightSum = 0;

        for(int num : nums) {
            totalSum += num;
        }
        int n = nums.length;
        int ans = n -1;

        long minDiff = totalSum/n;

        for(int i = 0; i < n -1; i++) {
            leftSum += (long) nums[i];
            rightSum = totalSum - leftSum;

            long currAbsDiff = Math.abs(leftSum/(i+1) - rightSum/(n-i-1));
            if(currAbsDiff < minDiff) {
                minDiff = currAbsDiff;
                ans = i;
            } else if (currAbsDiff == minDiff) { // case : [0,0,0,0,0]
                ans = Math.min(ans,i);
            }
        }
        return ans;
    }

    public int minimumAverageDifference2(int[] nums) {
        int len = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len -i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }

}
