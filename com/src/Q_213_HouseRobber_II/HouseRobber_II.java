package Q_213_HouseRobber_II;

public class HouseRobber_II {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int maxFirst = robHouse(nums, 0, nums.length - 2);
        int maxSecond = robHouse(nums, 1, nums.length - 1);

        return Math.max(maxFirst,maxSecond);

    }

    public static int robHouse(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }
        return t1;
    }

}
