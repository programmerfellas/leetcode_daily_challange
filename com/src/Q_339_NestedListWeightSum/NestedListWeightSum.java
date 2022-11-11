package Q_339_NestedListWeightSum;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {

    public static void main(String[] args) {

    }


    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList,1);
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }

    public int dfs(List<NestedInteger> nestedList, int depth) {
        int total = 0;
        for(NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()) {
                total += nestedInteger.getInteger() * depth;
            } else {
                total += dfs(nestedInteger.getList(),depth + 1);
            }
        }
        return total;
    }
}
