package Q_374_GuessNumberHigherOrLower;

public class GuessNumberHigherLower {

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public int guessNumber2(int n) {
        for (int i = 1; i < n; i++)
            if (guess(i) == 0)
                return i;
        return n;
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if(res == 0) {
                return mid;
            } else if (res < 0){ // higher
                high = mid - 1;
            } else { // lower
                low = mid + 1;
            }
        }
        return -1;
    }


//    You call a pre-defined API int guess(int num), which returns three possible results:
//
//    -1: Your guess is higher than the number I picked (i.e. num > pick).
//    1: Your guess is lower than the number I picked (i.e. num < pick).
//    0: your guess is equal to the number I picked (i.e. num == pick).
    public static int guess(int num) {
        int pick = 6;
        if(num > pick) {
            return -1;
        } else if(num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
