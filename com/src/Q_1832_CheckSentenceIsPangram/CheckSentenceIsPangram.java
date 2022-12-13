package Q_1832_CheckSentenceIsPangram;

import java.util.HashSet;
import java.util.Set;

public class CheckSentenceIsPangram {

    public static void main(String[] args) {

    }

    public boolean approach1(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }

        return set.size() == 26;
    }


    // Time complexity: O(n) , Space complexity: O(1)
    public boolean approach2(String sentence) {
        // Array 'seen' of size 26.
        boolean[] seen = new boolean[26];

        // For every letter 'currChar', we find its ASCII code,
        // and update value at the mapped index as true.
        for (char currChar : sentence.toCharArray()) {
            seen[currChar - 'a'] = true;
        }

        // Once we finish iterating, check if 'seen' contains false.
        for (boolean status : seen) {
            if (!status) return false;
        }

        return true;
    }


    public boolean approach3(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char)('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if (sentence.indexOf(currChar) == -1)
                return false;
        }

        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }
}
