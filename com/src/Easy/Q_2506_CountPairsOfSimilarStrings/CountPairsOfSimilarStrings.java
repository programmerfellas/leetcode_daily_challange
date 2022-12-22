package Easy.Q_2506_CountPairsOfSimilarStrings;

import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings {

    public static void main(String[] args) {
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        similarPairs(words);
    }

    public static int similarPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i+1; j < words.length; j++) {
                count += checkWords(words[i],words[j]);
            }
        }
        return count;
    }


    public static int checkWords(String s,String t) {
        Set<Character> sSet = new HashSet<>();
        Set<Character> tSet = new HashSet<>();

        for(char c : s.toCharArray()) {
            sSet.add(c);
        }

        for(char c : t.toCharArray()) {
            tSet.add(c);
        }
        return sSet.equals(tSet) ? 1 : 0;
    }
}
