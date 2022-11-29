package Q_907_SumSubarrayMinimums;

import java.util.Stack;

public class SumSubarrayMinimums {

    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        System.out.println(sumSubarrayMins4(arr));
    }

    public static int sumSubarrayMins(int[] arr) {

        int total = 0;
        for(int i = 0; i < arr.length;i++) {
            int min = arr[i];
            for (int j = i; j < arr.length;j++){
                min = Math.min(min,arr[j]);
                total += min;
            }
        }
        return total;
    }

    public static int sumSubarrayMins2(int[] arr) {

        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        // building monotonically increasing stack
        for (int i = 0; i <= arr.length; i++) {

            // when i reaches the array length, it is an indication that
            // all the elements have been processed, and the remaining
            // elements in the stack should now be popped out.

            while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {

                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account

                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            stack.push(i);
        }

        return (int) (sumOfMinimums);
    }


    public int sumSubarrayMins3(int[] arr) {
        int len = arr.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int j, k;

        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == len ? Integer.MIN_VALUE : arr[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                sum += (long)arr[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        return (int)(sum % (long) (1e9 + 7));
    }

    // https://leetcode.com/problems/sum-of-subarray-minimums/discuss/2118729/Very-detailed-stack-explanation-O(n)-or-Images-and-comments
    public static int sumSubarrayMins4(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long)1e9 + 7;
        stack.push(-1);

        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2 < arr.length) ? arr[i2] : 0;

            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (long)(left * right * (long)arr[index]) % M;
                res += add ;
                res %= M;
            }
            stack.push(i2);
        }
        return (int)res;
    }
}
