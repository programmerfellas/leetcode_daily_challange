package Q_1657_DetermineTwoStringsAreClose;

import java.util.*;

public class DetermineTwoStringsAreClose {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(closeStrings(word1,word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character,Integer> word1Map = new HashMap<>();
        HashMap<Character,Integer> word2Map = new HashMap<>();

        for(int i = 0; i < word1.length();i++) {
            word1Map.put(word1.charAt(i),word1Map.getOrDefault(word1.charAt(i),0)+1);
        }

        for(int i = 0; i < word2.length();i++) {
            word2Map.put(word2.charAt(i),word2Map.getOrDefault(word2.charAt(i),0)+1);
        }

        if(!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }

        List<Integer> w1List = new ArrayList<>(word1Map.values());
        List<Integer> w2List = new ArrayList<>(word2Map.values());
        Collections.sort(w1List);
        Collections.sort(w2List);
        return w1List.equals(w2List);
    }

    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                    (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        return Arrays.equals(word1Map, word2Map);
    }

    public boolean closeStrings3(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] frequencyOne = getFrequencyArray(word1);
        int[] frequencyTwo = getFrequencyArray(word2);
        for (int i = 0; i < frequencyOne.length; i++) {
            if (frequencyOne[i] == 0 && frequencyTwo[i] != 0) {
                return false;
            }
        }
        Arrays.sort(frequencyOne);
        Arrays.sort(frequencyTwo);
        for (int i = 0; i < frequencyOne.length; i++) {
            if (frequencyOne[i] != frequencyTwo[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getFrequencyArray(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }
}
