package Q_868_Binary_Gap;

public class BinaryGap {

    public static void main(String[] args) {
        int n = 22;
        System.out.println(binaryGap(n));
    }

    public static int binaryGap1(int n) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((n >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }
    public static int binaryGap(int n) {
        int lastOnePosition = -1;
        int currPosition = 0;
        int maxGap = 0;
        while (n > 0) {
            int rem = n % 2;
            n /= 2;
            if (rem == 1) {
                if (lastOnePosition != -1) {
                    maxGap = Math.max(maxGap, currPosition - lastOnePosition);
                }
                lastOnePosition = currPosition;
            }
            currPosition++;
        }
        return maxGap;
    }
}
