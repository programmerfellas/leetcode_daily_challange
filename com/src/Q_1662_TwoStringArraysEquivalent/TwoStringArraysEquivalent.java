package Q_1662_TwoStringArraysEquivalent;

public class TwoStringArraysEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < Math.max(word1.length,word2.length); i++) {
            if(i < word1.length) {
                sb1.append(word1[i]);
            }
            if(i < word2.length) {
                sb2.append(word2[i]);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static boolean approach2(String[] word1, String[] word2) {
        return String.join("",word1).equals(String.join("",word2));
    }
}
