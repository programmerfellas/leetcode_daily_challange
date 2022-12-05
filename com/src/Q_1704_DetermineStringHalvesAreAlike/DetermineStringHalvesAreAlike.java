package Q_1704_DetermineStringHalvesAreAlike;

public class DetermineStringHalvesAreAlike {

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int size = s.length();
        String vowels = "aeiouAEIOU";
        if(size == 0) return false;

        int mid = size / 2;
        int first = 0,second = 0;
        for (int i = 0; i < size; i++) {
            if(vowels.indexOf(s.charAt(i)) != -1) {
                if (mid <= i) first++;
                else second++;
            }
        }
        return (first == second);
    }

    private static final String VOWELS = "aeiouAEIOU";

    public boolean halvesAreAlike2(String s) {
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                count--;
            }
        }
        return count == 0;
    }
}
