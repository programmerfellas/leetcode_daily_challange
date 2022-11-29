package Q_380_InsertDeleteGetRandom;

import java.util.*;

public class InsertDeleteGetRandom {

    public static void main(String[] args) {

    }

    Map<Integer,Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public InsertDeleteGetRandom() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(dict.containsKey(val)) {
            return false;
        }

        dict.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if(!dict.containsKey(val)) {
            return false;
        }

        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx,lastElement);
        dict.put(lastElement,idx);

        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
