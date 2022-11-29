package Q_246_StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public static void main(String[] args) {
        String num = "762";
        System.out.println(isStrobogrammatic(num));
    }

    public static boolean isStrobogrammatic(String num) {
        StringBuilder rotatedStringBuilder = new StringBuilder();
        Map<Character,Character> map = new HashMap<>(Map.of('0','0','1','1','6','9','8','8','9','6'));

        for(int i = num.length() - 1; i >=0; i--) {
            char ch = num.charAt(i);
            if(!map.containsKey(ch)) {
                return false;
            }

            rotatedStringBuilder.append(map.get(ch));
        }

        return rotatedStringBuilder.toString().equals(num);
    }

    public static boolean isStrobogrammatic2(String num) {

        // Note that using a String here and appending to it would be
        // poor programming practice.
        StringBuilder rotatedStringBuilder = new StringBuilder();

        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '1' || c == '8') {
                rotatedStringBuilder.append(c);
            } else if (c == '6') {
                rotatedStringBuilder.append('9');
            } else if (c == '9') {
                rotatedStringBuilder.append('6');
            } else { // This must be an invalid digit.
                return false;
            }
        }

        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }

    public boolean isStrobogrammatic3(String num) {

        Map<Character,Character> rotatedDigits = new HashMap<>(Map.of('0','0','1','1','6','9','8','8','9','6'));
        int left = 0;
        int right = num.length() - 1;
        while(left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if(!rotatedDigits.containsKey(rightChar) || rotatedDigits.get(rightChar) != leftChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
