package Hard.Q_2509_CycleLengthQueriesInTree;

public class CycleLengthQueriesInTree {

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{5,3},{4,7},{2,3}};
        cycleLengthQueries(n, queries);
    }

    public static int[] cycleLengthQueries(int n, int[][] queries) {
        int[] count = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            count[i] += dis(queries[i][0], queries[i][1]);
        }
        return count;
    }
    private static int dis(int n1, int n2){
        int count = 0;
        while(n1 != n2){
            if(n1 > n2) n1 /= 2;
            else    n2 /= 2;
            count++;
        }
        return count+1;
    }
}
