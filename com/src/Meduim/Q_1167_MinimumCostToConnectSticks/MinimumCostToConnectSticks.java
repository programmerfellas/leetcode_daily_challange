package Meduim.Q_1167_MinimumCostToConnectSticks;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        int[] sticks = {1,8,3,5};
        System.out.println(connectSticks(sticks));
    }
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int stick : sticks) {
            pq.offer(stick);
        }
        int minCost = 0;

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            int currCost = first + second;
            pq.offer(currCost);
            minCost += currCost;
        }
        return minCost;
    }
}
