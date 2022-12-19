package Q_198_HouseRobber;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] maximumRobAmount = new int[n + 1];
        maximumRobAmount[n] = 0;
        maximumRobAmount[n-1] = nums[n-1];


        for(int i = n -2; i >= 0; --i) {
            maximumRobAmount[i] = Math.max(maximumRobAmount[i+1],maximumRobAmount[i+2] + nums[i]);
        }

        return maximumRobAmount[0];
    }
}
