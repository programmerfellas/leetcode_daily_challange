package Q_1207_UniqueNumberOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurrences {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> freqSet = new HashSet<>(map.values());

        // If the set size is equal to the map size,
        // It implies frequency counts are unique.
        return map.size() == freqSet.size();
    }

}
