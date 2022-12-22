package Meduim.Q_1362_ClosestDivisors;

public class ClosestDivisors {

    public static void main(String[] args) {
        closestDivisors(123);
    }

    public static int[] closestDivisors(int num) {
        int sqr = (int)Math.sqrt(num+2);

        for(int i = sqr; i > 0; --i) {
            if((num + 1) % i == 0)
                return new int[]{i, (num + 1) / i};
            if((num + 2) % i == 0)
                return new int[]{i, (num + 2) / i};
        }

        return new int[]{};
    }
}
