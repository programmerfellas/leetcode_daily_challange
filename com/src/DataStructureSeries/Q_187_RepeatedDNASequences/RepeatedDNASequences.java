package DataStructureSeries.Q_187_RepeatedDNASequences;

import java.util.*;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences2(s));
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> seen = new HashSet<>(), output = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String dns = s.substring(i,i+10);
            if(seen.contains(dns)) output.add(dns);
            seen.add(dns);
        }

        return new ArrayList<String>(output);
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String dns = s.substring(i,i+10);
            map.put(dns,map.getOrDefault(dns,0)+1);
        }

        List<String> list = new ArrayList<String>();
        for(Map.Entry<String,Integer> set :  map.entrySet()) {
            if(set.getValue() > 1) {
                list.add(set.getKey());
            }
        }

        return list;
    }
}
