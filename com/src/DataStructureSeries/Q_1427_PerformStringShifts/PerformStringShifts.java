package DataStructureSeries.Q_1427_PerformStringShifts;

public class PerformStringShifts {

    public static void main(String[] args) {
        String s = "abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s,shift));
    }

    public static String stringShift(String string, int[][] shift) {
        int len = string.length();
        for (int[] move : shift) {
            int direction = move[0];
            int amount = move[1] % len;
            if (direction == 0) {
                // Move necessary amount of characters from front to end
                string = string.substring(amount) + string.substring(0, amount);
            } else {
                // Move necessary amount of characters from end to front
                string = string.substring(len - amount) + string.substring(0, len - amount);
            }
        }
        return string;
    }



}
