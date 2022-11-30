package Q_2464_MinimumSubarraysValidSplit;

import java.util.Arrays;

public class MinimumSubarraysValidSplit {

    public static void main(String[] args) {
        int[] nums = {2,6,3,4,3};
        System.out.println(validSubarraySplit(nums));
    }

    public static int validSubarraySplit(int[] a) {
        int[] dp = new int[a.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.println(dp[i] + " , " + dp[j]);
                if (dp[j] != -1 && gcd(a[i], a[j]) > 1) {
                    dp[i + 1] = dp[i + 1] != -1 ? Math.min(1 + dp[j], dp[i + 1]) : 1 + dp[j];
                }
            }
        }
        return dp[a.length];
    }

    static int gcd(int a, int b) {
        System.out.println("+++++++++++++++GCD++++++++++++");
        System.out.println(a + " , " + b);
        return b == 0 ? a : gcd(b, a % b);
    }
}
