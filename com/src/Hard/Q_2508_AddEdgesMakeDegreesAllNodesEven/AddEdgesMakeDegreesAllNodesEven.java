package Hard.Q_2508_AddEdgesMakeDegreesAllNodesEven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddEdgesMakeDegreesAllNodesEven {

    public static void main(String[] args) {

    }

    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Set<Integer>> adjacencyList  = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new HashSet<>());
        }
        for (List<Integer> e : edges) {
            adjacencyList.get(e.get(0)).add(e.get(1));
            adjacencyList.get(e.get(1)).add(e.get(0));
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> curSet = adjacencyList.get(i);
            if (curSet.size() % 2 == 1) {
                odd.add(i);
            }
        }
        if (odd.size() == 2) {
            for (int i = 1; i <= n; i++) {
                int firstElement = odd.get(0);
                int secondElement = odd.get(1);
                if (!adjacencyList.get(firstElement).contains(i) && !adjacencyList.get(secondElement).contains(i)) {
                    return true;
                }
            }
        }
        if (odd.size() == 4) {
            int firstElement = odd.get(0);
            int secondElement = odd.get(1);
            int thirdElement = odd.get(2);
            int fourthElement = odd.get(3);
            return (!adjacencyList.get(firstElement).contains(secondElement) && !adjacencyList.get(thirdElement).contains(fourthElement))
                    || (!adjacencyList.get(firstElement).contains(thirdElement) && !adjacencyList.get(secondElement).contains(fourthElement))
                    || (!adjacencyList.get(firstElement).contains(fourthElement) && !adjacencyList.get(secondElement).contains(thirdElement));
        }
        return odd.size() == 0;
    }
}
