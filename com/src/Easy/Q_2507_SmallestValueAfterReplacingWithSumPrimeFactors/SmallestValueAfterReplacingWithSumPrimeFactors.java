package Easy.Q_2507_SmallestValueAfterReplacingWithSumPrimeFactors;

public class SmallestValueAfterReplacingWithSumPrimeFactors {

    public static void main(String[] args) {
        smallestValue(15);
    }

    public static int smallestValue(int n) {
        int sum = n;
        while(true){
            int sum1 = 0;
            int c = 2;
            //for prime factors
            while(n > 1){
                if(n % c == 0){
                    sum1 += c;
                    n /= c;
                } else c++;
            }
            n = sum1;
            // no more less sum can encounter
            if(sum == sum1)break;
            else sum = sum1;
        }
        return sum;
    }
}
