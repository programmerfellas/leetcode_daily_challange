package Q_2131_LongestPalindromebyConcatenatingTwoLetterWords;

/*
    Algorithm
        1. Count the number of occurrences of each word using a hashmap (can use a Counter in Python).
        2. Initialize answer = 0, central = false. The answer will denote the number of words in the final string and the boolean variable central will denote whether we have a central word.
        3. For each palindromic word do the following. If count[word] is even, increase answer by count[word]. Otherwise, if count[word] is odd, increase answer by count[word] - 1 and set central=true (we can use the word as a central word).
        4. For each non-palindrome word such that word[0] < word[1] (we need this condition to consider each pair only once and not twice, e.g. we don't want to consider both baba and ab separately) increase answer by 2 dot min (count[word], count[reversedWord]) (we use min(count[word],count[reversedWord]) pairs of the corresponding words).
        5. If central=true, increase answer by 11.
        6. Return 2 dot answer. (Because each word has a length of 22).
 */
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeConcatenatingTwoLetterWords {

    public static void main(String[] args) {
//        String[] words = {"ab","ty","yt","lc","cl","ab"};
        String[] words = {"lc","cl","gg"};
        System.out.println(longestPalindrome2(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        // Count all the character and stores into HashMap
        for (String word : words) count.put(word, count.getOrDefault(word, 0) + 1);

        int answer = 0;
        boolean central = false;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                // If count[word] is even, increase answer by count[word]. Otherwise,
                // if count[word] is odd, increase answer by count[word] - 1 and set central=true (we can use the word as a central word).
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true;
                }
                // consider a pair of non-palindrome words such that one is the reverse of another
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reversedWord)) {
                    answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                }
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }

    public static int longestPalindrome2(String[] words) {
        final int alphabetSize = 26;
        int[][] count = new int[alphabetSize][alphabetSize];
        for (String word : words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int answer = 0;
        boolean central = false;
        for (int i = 0; i < alphabetSize; i++) {
            if (count[i][i] % 2 == 0) {
                answer += count[i][i];
            } else {
                answer += count[i][i] - 1;
                central = true;
            }
            for (int j = i + 1; j < alphabetSize; j++) {
                answer += 2 * Math.min(count[i][j], count[j][i]);
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
}
