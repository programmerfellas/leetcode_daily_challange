package DataStructureSeries.Q_1588_SumOfAllOddLengthSubarrays;
/*
    Solution:
    Start by finding the total number of subarrays that each index appears in.
    This is calculated by taking the number of subarrays ending at that index (i + 1) multiplied by the number
    of subarrays starting at that index (n - i).

    To find the number of odd subarrays containing an index, take the total subarrays containing
    that index and divide by 2. If the total containing the array was odd, add 1 to the result to take into account
    the extra odd subarray.

    Multiply each number and the number of odd subarrays it appears in. Return the sum of this.

    Example of how to calculate the total subarrays an index appears in
    If there are A subarrays ending where we are at (B), and C subarrays beginning where we are at (B),
    then the total times B appears in subarrays is A*C.

    Here's an example: arr = [4,8,5,6,1]

    Let's look at how many total subarrays index 2 (value 5) is in. Index 2 will be our B.
    There are 3 subarrays that end with 5: [4,8,5] [8,5] and [5]. We'll call these 3 subarrays A.
    There are 3 subarrays that start with 5: [5] [5,6] and [5,6,1]. These 3 subarrays will be C.

    Looking at the first subarray in A [4,8,5], we can add every combination in C to it.
    [4,8,5] with [5] gives [4,8,5]
    [4,8,5] with [5,6] gives [4,8,5,6]
    [4,8,5] with [5,6,1] gives [4,8,5,6,1]

    Notice how all 3 subarrays of C were added to 1 of the subarrays of A? This is possible because
    they can be connected with B.

    Repeat the process for the second subarray in A [8,5]. Add every subarray in C to the second subarray in A.
    [8,5] with [5] gives [8,5]
    [8,5] with [5,6] gives [8,5,6]
    [8,5] with [5,6,1] gives [8,5,6,1]

    3 more subarrays were created with B as the connecting index.

    Repeat once more for [5] (the last subarray in A).
    [5] with [5] gives [5]
    [5] with [5,6] gives [5,6]
    [5] with [5,6,1] gives [5,6,1]

    The grand total subarrays here was 3*3 = 9.

 */

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/?envType=study-plan&id=data-structure-iii
// https://www.youtube.com/watch?v=J5IIH35EBVE&feature=emb_title

public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int end = i + 1;
            int start = n - i;
            int total = end * start;
            int odd = total / 2;
            if(total % 2 == 1) {
                odd++;
            }
            result += odd * arr[i];
        }
        return result;
    }
}
