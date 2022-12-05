package Q_1165_SingleRowKeyboard;

public class SingleRowKeyboard {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyzcba";
        String word = "cba";
        calculateTime(keyboard,word);
    }

    public static int calculateTime(String keyboard, String word) {
        int[] keyIndices = new int[26];

        for(int i = 0; i < 26; i++) {
            keyIndices[keyboard.charAt(i) - 'a'] = i;
        }

        int prev = 0;
        int result = 0;

        for(char c : word.toCharArray()) {
            result += Math.abs(prev - keyIndices[c - 'a']);
            prev = keyIndices[c - 'a'];
        }
        return result;
    }

}
