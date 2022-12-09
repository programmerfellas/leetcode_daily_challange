package Q_1640_CheckArrayFormationThroughConcatenation;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        System.out.println(canFormArray(arr,pieces));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        Map<Integer,int[]> mapping = new HashMap<>();
        for(int[] p : pieces) {
            mapping.put(p[0],p);
        }

        int i = 0;
        while (i < n) {
            if(!mapping.containsKey(arr[i])) {
                return false;
            }

            int[] targetP = mapping.get(arr[i]);

            for(int target : targetP) {
                if(target != arr[i]) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}
