package Q_2320_CountNumberWaysPlaceHouses;

import java.util.Arrays;

public class CountNumberWaysPlaceHouses {

    public static void main(String[] args) {
        countHousePlacements(2);
    }

    public static int countHousePlacements(int n) {
        long f0 = 1;
        long f1 = 2;
        long mod = (long) (Math.pow(10, 9) + 7);
        for (int i = 2; i <= n; i++) {
            long f2 = (f0 + f1) % mod;
            f0 = f1;
            f1 = f2;
        }
        return (int) ((f1 * f1) % mod);
    }

    public static int countHousePlacements3(int n) {
        long mod = 100000007;
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return (int) ((int)((dp[n]) * dp[n]) % mod);

    }

    static long m = 1000000007;
    static long[] dp;

    public static int countHousePlacements2(int n) {
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        long ans = solve(n);
        return (int)((ans * ans) % m);

    }

    // Returns all possible ways we can place houses in N places
    public static long solve(int n){

        // base case (no place left to place a new home)
        if(n <= 0){
            return 1;
        }

        // Early return
        if(dp[n] != -1){
            return dp[n];
        }

        long usedCurrPlace = 1L * solve(n-2);
        long notUsedCurrPlace = 1L * solve(n-1);

        return dp[n] = (usedCurrPlace + notUsedCurrPlace) % m;
    }
}
