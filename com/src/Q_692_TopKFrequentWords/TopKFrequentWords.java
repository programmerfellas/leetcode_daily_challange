package Q_692_TopKFrequentWords;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        System.out.println(approach1(words,k));

    }

    public static List<String> approach1(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(cnt.keySet());
        Collections.sort(candidates,
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w1.compareTo(w2) : cnt.get(w2) - cnt.get(w1));
        return candidates.subList(0, k);
    }

}
