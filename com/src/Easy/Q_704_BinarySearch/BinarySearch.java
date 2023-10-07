package Easy.Q_704_BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length, low = 0 ,high = n - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target)
                low = mid;
            else
                high = mid - 1;
        }

        return nums[low] == target ? low : -1;  // low == high
    }
}
