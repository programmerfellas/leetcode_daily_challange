package DyanamicProgramming.HouseRobber;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;

        // Special handling for empty array case.
        if (n == 0) {
            return 0;
        }

        int[] maxRobbedAmount = new int[nums.length + 1];

        // Base case initializations.
        maxRobbedAmount[n] = 0;
        maxRobbedAmount[n - 1] = nums[n - 1];

        // DP table calculations.
        for (int i = n - 2; i >= 0; --i) {

            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }

        return maxRobbedAmount[0];
    }
}
