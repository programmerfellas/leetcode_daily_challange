package DataStructureSeries.Q_214_ShortestPalindrome;

public class ShortestPalindrome {

    public static void main(String[] args) {
        String s = "abcd";//s = "aacecaaa";
        System.out.println(shortestPalindrome2(s));
    }

    /*
        The idea is to use two anchors j and i to compare the String from beginning and end.
        If j can reach the end, the String itself is Palindrome.
        Otherwise, we divide the String by j, and get mid = s.substring(0, j) and suffix.
        We reverse suffix as beginning of result and recursively call shortestPalindrome to get result of mid
        then append suffix to get result.
     */
    public static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString()
                + shortestPalindrome(s.substring(0, j)) + suffix;
    }


    public static String shortestPalindrome2(String s) {
        int i = 0, end = s.length() - 1, j = end;
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                i = 0; end--; j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }

}
