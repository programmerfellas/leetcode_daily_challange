package Q_334_IncreasingTripletSubsequence;
/*
    Approach : Liner Scan

        first_num = second_num = some very big number
        for n in nums:
            if n is the smallest number:
                first_num = n
            else if n is second-smallest number:
                second_num = n
            else n is bigger than both first_num and second_num:
                # We have found our triplet, return True

        # After loop has terminated
        # If we have reached this point, there is no increasing triplet, return False
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for (int num : nums) {
            if(num <= firstNum) {
                firstNum = num;
            } else if(num <= secondNum) {
                secondNum = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
