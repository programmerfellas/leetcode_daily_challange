package Q_205_IsomorphicStrings;

// 205. Isomorphic Strings

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphicStrings(s,t));
    }

    public static boolean isIsomorphicStrings(String s,String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for(int i = 0; i < s.length();i++) {
            if(m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        return true;
    }

}
