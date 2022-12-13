package Q_392_IsSubsequence;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
}
