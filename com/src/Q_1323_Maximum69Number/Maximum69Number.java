package Q_1323_Maximum69Number;

public class Maximum69Number {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(approach1(num));
    }

    public static int approach1 (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        for(int i = 0; i < sb.length();i++) {
            if(sb.charAt(i) == '6') {
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public int approach2 (int num) {
        // Convert the input 'num' to the string 'numString'.
        String numString = "" + num;

        // Use the built-in function to replace the first '6' with '9'.
        // Return the integer converted from the modified 'numString'.
        return Integer.parseInt(numString.replaceFirst("6", "9"));
    }

    public int approach3 (int num) {
        // Since we start with the lowest digit, initialize currDigit = 0.
        int numCopy = num;
        int indexSix = -1;
        int currDigit = 0;

        // Check every digit of 'numCopy' from low to high.
        while (numCopy > 0) {
            // If the current digit is '6', record it as the highest digit of 6.
            if (numCopy % 10 == 6)
                indexSix = currDigit;

            // Move on to the next digit.
            numCopy /= 10;
            currDigit++;
        }

        // If we don't find any digit of '6', return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'.
        return indexSix == -1 ? num : num + 3 * (int)Math.pow(10, indexSix);
    }
}
