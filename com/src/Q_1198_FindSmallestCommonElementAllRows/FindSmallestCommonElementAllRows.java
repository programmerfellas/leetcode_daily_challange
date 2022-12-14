package Q_1198_FindSmallestCommonElementAllRows;

import java.util.HashMap;

public class FindSmallestCommonElementAllRows {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5},
                {2,4,5,8,10},
                {3,5,7,9,11},
                {1,3,5,7,9}};
        int[][] mat1 = {{1,2,3},{2,3,4},{2,3,5}};
        System.out.println(smallestCommonElement(mat));
    }

    public static int smallestCommonElement(int[][] mat) {
        int smallestElement = Integer.MAX_VALUE;
        boolean flg = false;
        HashMap<Integer,Integer> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = map.getOrDefault(mat[i][j],0) + 1;
                map.put(mat[i][j],val);
                if(val == mat.length) {
                    return mat[i][j];
                }
            }
        }

//        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            if(entry.getValue() == m) {
//                flg = true;
//                smallestElement = Math.min(smallestElement,entry.getKey());
//            }
//        }
        return flg ? smallestElement : -1;
    }

    public static int smallestCommonElement2(int[][] mat) {
        int[] bucket = new int[10001];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                bucket[mat[i][j]]++;
                if(bucket[mat[i][j]] == mat.length) return mat[i][j];
            }
        }
        return -1;
    }

    public static int smallestCommonElement4(int[][] mat) {
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (++count[mat[i][j]] == n) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }

    public int smallestCommonElement3(int[][] mat) {
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++count[mat[i][j]];
            }
        }
        for (int k = 1; k <= 10000; ++k) {
            if (count[k] == n) {
                return k;
            }
        }
        return -1;
    }
}
