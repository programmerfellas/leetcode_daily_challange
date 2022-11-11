package Q_1921_EliminateMaximumNumberMonsters;

import java.util.Arrays;

public class EliminateMaximumNumberMonsters {

    public static void main(String[] args) {
        int[] dist = {1,3,4};
        int[] speed = {1,1,1};
        System.out.println(eliminateMaximum(dist,speed));
    }
    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] times = new double[dist.length];
        for(int i = 0; i < dist.length; i++) {
            times[i] = (double) dist[i] / (double) speed[i];
        }

        Arrays.sort(times);
        int t = 0;
        int ans = 0;
        for(double a : times) {
            if(a <= t) {
                break;
            } else {
                ans++;
                t++;
            }
        }
        return ans;
    }
}
