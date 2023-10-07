package Meduim.Q_343_IntegerBreak;


/*
1. If n is less than or equal to 3, it returns n - 1. This is because for values of n less than 4,
    it's better to break it into smaller integers (e.g., 2 = 1 + 1) to maximize the product.
2. If n is divisible by 3, it tries to break it into as many 3s as possible, as this will maximize the product.
    For example, for n = 6, it returns 3 * 3 = 9.
3. If n leaves a remainder of 1 when divided by 3, it breaks it into as many 3s as possible and leaves one 3 as 4.
    For example, for n = 10, it returns 3 * 3 * 4 = 36.
4. If n leaves a remainder of 2 when divided by 3, it breaks it into as many 3s as possible and adds one more 3.
    For example, for n = 8, it returns 3 * 3 * 2 = 18.
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int quotient = n / 3, remainder = n % 3;
        int r0 = (int)Math.pow(3, quotient);
        int r1 = (int)Math.pow(3, quotient - 1) * 4;
        int rM = (int)Math.pow(3, quotient) * 2;
        return remainder == 0 ? r0 : (remainder == 1 ? r1 : rM);
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
