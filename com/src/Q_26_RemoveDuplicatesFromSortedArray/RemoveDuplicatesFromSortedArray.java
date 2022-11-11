package Q_26_RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]) {
                count++;
            }
        }

        return count;
    }

    public int removeDuplicates1(int[] nums) {

        int left = 0; //current index
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left]) { //new number
                left++; //move current index
                nums[left] = nums[right]; //fill current index with new number
            }
            right++;
        }

        return left+1;
    }
}
