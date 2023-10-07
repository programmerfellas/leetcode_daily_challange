package Meduim.Q_55_JumpGame;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        canJump2(nums);
    }

    public static boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}
