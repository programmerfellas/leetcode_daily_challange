package Q_339_NestedListWeightSum;

import java.util.List;

public class NestedListWeightSum {

    public static void main(String[] args) {

    }


    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList,1);
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
