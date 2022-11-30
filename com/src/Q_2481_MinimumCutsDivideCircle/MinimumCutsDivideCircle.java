package Q_2481_MinimumCutsDivideCircle;

public class MinimumCutsDivideCircle {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfCuts(n));
    }

    public static int numberOfCuts(int n) {
        return n == 1 ? 0 : (n % 2 == 0 ? n / 2 : n);
    }
}
