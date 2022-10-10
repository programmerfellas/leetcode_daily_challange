package DyanamicProgramming.PaintHouse;

public class PaintHouse {

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        for (int n = costs.length - 2; n >= 0; n--) {
            // Total cost of painting the nth house red.
            costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
            // Total cost of painting the nth house green.
            costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
            // Total cost of painting the nth house blue.
            costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
        }

        if (costs.length == 0) return 0;

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}
