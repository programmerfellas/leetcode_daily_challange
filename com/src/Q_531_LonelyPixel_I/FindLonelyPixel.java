/*
    531. Lonely Pixel I
 */
package Q_531_LonelyPixel_I;

public class FindLonelyPixel {
    public static void main(String[] args) {
//        char[][] picture = {{'W','W','B'},{'W','B','W'},{'B','W','W'}};
        char[][] picture = {{'W','B','W','W'},{'W','W','W','B'},{'B','W','B','W'},{'W','B','W','W'}};
        System.out.println(findLonelyPixel(picture));
    }


    public static int findLonelyPixel(char[][] picture) {
        int answer = 0;
        int m = picture.length; // row (left to right)
        int n = picture[0].length; // column (top to bottom)

        // Array to store the black cell of row and column
        int[] row = new int[m];
        int[] column = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    row[i]++;
                    column[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] == 'B' && row[i] == 1 && column[j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
