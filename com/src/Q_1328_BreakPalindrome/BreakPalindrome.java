package Q_1328_BreakPalindrome;

public class BreakPalindrome {
    public static void main(String[] args) {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));
    }

    public static String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if(length == 1) {
            return "";
        }

        char[] ch = palindrome.toCharArray();
        for(int i = 0; i < length / 2; i++) {
            if(ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        ch[length - 1] = 'b';
        return String.valueOf(ch);
    }
}
