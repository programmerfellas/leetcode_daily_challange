package DataStructureSeries.Q_5_LongestPalindromicSubstring;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome2(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        Boolean[][] dp = new Boolean[n][n];
        int start, end;
        start = end = 0;
        for (int i= n-1; i>= 0; i--) {
            for (int j = i; j<n; j++) {
                if (j-i < 3) { //base case
                    dp[i][j] = (c[i] == c[j]);
                } else {
                    dp[i][j] = (c[i] == c[j] && dp[i+1][j-1]);
                }

                if (dp[i][j] && (end-start <= j-i)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }

    private static int lo,maxLen;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
