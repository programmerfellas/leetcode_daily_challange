package Q_1216_ValidPalindromeIII;

public class ValidPalindromeIII {

    public static void main(String[] args) {
        String s = "abcdeca";
        int k = 2;
        System.out.println(isValidPalindrome(s,k));
    }


    static int isValidPalindrome(Integer memo[][],String s, int i, int j) {

        // Base case, only 1 letter remaining.
        if (i == j)
            return 0;

        // Base case 2, only 2 letters remaining.
        if (i == j - 1)
            return s.charAt(i) != s.charAt(j) ? 1 : 0;

        //Return the precomputed value if exists.
        if (memo[i][j] != null)
            return memo[i][j];

        // Case 1: Character at `i` equals character at `j`
        if (s.charAt(i) == s.charAt(j))
            return memo[i][j] = isValidPalindrome(memo,s, i + 1, j - 1);

        // Case 2: Character at `i` does not equal character at `j`.
        // Either delete character at `i` or delete character at `j`
        // and try to match the two pointers using recursion.
        // We need to take the minimum of the two results and add 1
        // representing the cost of deletion.
        return memo[i][j] = 1 + Math.min(isValidPalindrome(memo,s, i + 1, j), isValidPalindrome(memo,s, i, j - 1));
    }

    public static boolean isValidPalindrome(String s, int k) {
        Integer memo[][] = new Integer[s.length()][s.length()];

        // Return true if the minimum cost to create a palindrome by only deleting the letters
        // is less than or equal to `k`.
        return isValidPalindrome(memo,s, 0, s.length() - 1) <= k;
    }

}
