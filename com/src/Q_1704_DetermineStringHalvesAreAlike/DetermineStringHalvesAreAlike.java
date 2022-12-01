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
}
