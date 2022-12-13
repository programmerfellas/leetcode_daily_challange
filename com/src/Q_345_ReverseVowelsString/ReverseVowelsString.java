package Q_345_ReverseVowelsString;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsString {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));

        while (left < right) {
            if(!vowels.contains(ch[left])) {
                left++;
                continue;
            }
            if(!vowels.contains(ch[right])) {
                right--;
                continue;
            }

            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }

        return new String(ch);
    }
}
