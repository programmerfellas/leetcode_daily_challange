package Q_2455_AverageValueEvenNumbersThatAreDivisibleThree;

public class AverageValueEvenNumbersThatAreDivisibleThree {

    public static void main(String[] args) {
        int[] nums = {1,3,6,10,12,15};
        System.out.println(averageValue(nums));
    }

    public static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for(Integer num : nums) {
            if(num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        return count == 0 ? 0 : sum/count;
    }
}
