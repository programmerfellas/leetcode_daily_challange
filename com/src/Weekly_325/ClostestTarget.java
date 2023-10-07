package Weekly_325;

public class ClostestTarget {

    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;

        closetTarget(words,target,startIndex);
    }

    public static int closetTarget(String[] words, String target, int start) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        int normal = Integer.MAX_VALUE;
        int circular = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(words[i].equalsIgnoreCase(target)) {
                normal = Math.abs(i - start);
                circular = 0;
                if(i > start) {
                    circular = start + n-i;
                } else {
                    circular = i + n - start;
                }
                ans = Math.min(normal, Math.min(ans,circular));
            }
        }

        return ans;
    }
}
