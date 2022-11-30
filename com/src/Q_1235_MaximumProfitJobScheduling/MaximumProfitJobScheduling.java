package Q_1235_MaximumProfitJobScheduling;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitJobScheduling {

    public static void main(String[] args) {
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
        System.out.println(maximumProfitJobScheduling.jobScheduling(startTime,endTime,profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Integer[] cache = new Integer[n];
        return dfs(0, jobs, cache);
    }

    private int dfs(int idx, int[][] jobs, Integer[] cache) {
        if (idx == jobs.length) {
            return 0;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        int nextIdx = idx + 1;
        while (nextIdx < jobs.length && jobs[idx][1] > jobs[nextIdx][0]) {
            nextIdx++;
        }
        int jobScheduled = jobs[idx][2] + dfs(nextIdx, jobs, cache);
        int jobNotScheduled = dfs(idx + 1, jobs, cache);
        return cache[idx] = Math.max(jobScheduled, jobNotScheduled);
    }

    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // Sorting on end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0);

        for(int[] job : jobs) {
            int val = job[2] + dp.floorEntry(job[0]).getValue();
            if(val > dp.lastEntry().getValue()) {
                dp.put(job[1],val);
            }
        }

        return dp.lastEntry().getValue();
    }
}
