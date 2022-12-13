package Q_931_MinimumFallingPathSum;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        Integer memo[][] = new Integer[matrix.length][matrix[0].length];

        // Start a DFS (with memoization) from each cell in the top row
        for(int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum,findMinFallingPathSum(matrix,0,startCol,memo));
        }

        return minFallingSum;
    }

    public static int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
        // base cases
        if(col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }

        // check if we have reached the last row
        if(row == matrix.length) {
            return matrix[row][col];
        }

        // check if the results are calculated before
        if(memo[row][col] != null) {
            return memo[row][col];
        }

        // calculated the minimum falling path sum starting from each possible next step
        int left = findMinFallingPathSum(matrix, row+1, col, memo);
        int middle = findMinFallingPathSum(matrix, row+1, col + 1, memo);
        int right = findMinFallingPathSum(matrix, row+1, col - 1, memo);

        memo[row][col] = Math.min(left,Math.min(middle,right) + matrix[row][col]);
        return memo[row][col];
    }

    public int minFallingPathSum2(int[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row + 1][col],
                            Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1])) + matrix[row][col];
                }
            }
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
        }
        return minFallingSum;
    }

}
