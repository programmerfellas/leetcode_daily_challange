package Q_409_LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) set.remove(ch);
            else set.add(ch);
        }

        if(set.size() <= 1) return s.length();
        return s.length() - set.size() + 1;

    }
}
