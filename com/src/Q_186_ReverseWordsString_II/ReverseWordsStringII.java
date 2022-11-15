package Q_186_ReverseWordsString_II;

public class ReverseWordsStringII {

    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);
    }

    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);  // reverse the whole string first
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ')
                r++;
            reverse(s, l, r-1);  // reverse words one by one
            r++;
        }
    }

    public static void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
