package MinimumDifficultyJobSchedule;

import java.util.Arrays;

public class MinimumDifficultyJobSchedule {

    public static void main(String[] args) {
        int[] jobDifficulty = {6,5,4,3,2,1};
        int d = 2;
        System.out.println(minDifficulty(jobDifficulty,d));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        // Edge case: make sure there is at least one job per day
        if (n < d) {
            return -1;
        }

        int[][] mem = new int[n][d + 1];

        for(int[] dp : mem) {
            Arrays.fill(dp,-1);
        }

        return dfs(0, d, jobDifficulty, mem);
    }

    private static int dfs(int idx, int daysRemaining, int[] jobDifficulty, int[][] mem) {

        // Base case: finish all remaining jobs in the last day
        if (daysRemaining == 1) {
            int max = 0;
            while (idx < jobDifficulty.length) {
                max = Math.max(max, jobDifficulty[idx++]);
            }
            return max;
        }

        // Use memoization to avoid repeated computation of states
        if (mem[daysRemaining][idx] != -1) {
            return mem[daysRemaining][idx];
        }

        int res = Integer.MAX_VALUE;
        int dailyMaxJobDiff = 0;
        // Iterate through possible starting index for the next day and ensure we have at least one job for each remaining day.
        for (int i = idx; i < jobDifficulty.length - daysRemaining + 1; i++) {
            dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[i]);
            res = Math.min(res, dailyMaxJobDiff + dfs(i + 1, daysRemaining - 1, jobDifficulty, mem));
        }
        mem[idx][daysRemaining] = res;
        return res;
    }
}
