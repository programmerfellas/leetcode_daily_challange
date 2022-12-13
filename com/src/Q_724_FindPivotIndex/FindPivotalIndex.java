package Q_724_FindPivotIndex;
// 724. Find Pivot Index

public class FindPivotalIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;

        // Add all the elements in leftSum
        for(int i = 0; i< nums.length; i++) {
            leftSum += nums[i];
        }

        //   i  leftSum   rightSum
        //   0    1       !=  28-1   => 17 == 27
        //   1    8       !=  27-7   => 17 == 20
        //   2    11      !=  20-3   => 17 == 17
        //   3    17      ==  17  return 3
        for(int i = 0; i < nums.length; i++) {
            rightSum += nums[i];

            if(leftSum == rightSum) {
                return i;
            }

            leftSum -= nums[i];
        }

        return -1;

    }
}
