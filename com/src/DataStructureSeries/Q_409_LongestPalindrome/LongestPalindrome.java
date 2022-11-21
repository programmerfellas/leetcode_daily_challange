package DataStructureSeries.Q_409_LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() < 1) return 0;
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) set.remove(ch);
            else set.add(ch);
        }

        if(set.size() <= 1) return s.length();
        return s.length() - set.size() + 1;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
