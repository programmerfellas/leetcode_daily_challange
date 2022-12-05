package Q_451_SortCharactersByFrequency;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "Aabb";//"tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i),counts.getOrDefault(s.charAt(i),0 ) + 1);
        }

        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a,b) -> counts.get(b) - counts.get(a));
        StringBuilder sb = new StringBuilder();
        for (char ch : characters) {
            int charCount = counts.get(ch);
            for(int i = 0; i < charCount; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
