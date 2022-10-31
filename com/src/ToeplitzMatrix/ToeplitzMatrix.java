package ToeplitzMatrix;

public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int r = 0; r < matrix.length; ++r) {
            for(int c = 0; c < matrix[0].length; ++c) {
                if(c > 0 && r > 0 && matrix[r-1][c-1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
