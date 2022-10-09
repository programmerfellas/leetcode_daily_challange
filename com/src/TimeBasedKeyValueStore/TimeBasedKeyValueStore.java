/*
    981. Time Based Key-Value Store
 */

package TimeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        String[] input = {"TimeMap", "set", "get", "get", "set", "get", "get"};
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList(""));
        list.add(Arrays.asList("foo","bar","1"));
        list.add(Arrays.asList("foo", "1"));
        list.add(Arrays.asList("foo", "3"));
        list.add(Arrays.asList("foo", "bar2", "4"));
        list.add(Arrays.asList("foo", "4"));
        list.add(Arrays.asList("foo", "4"));
        TimeBasedKeyValueStore timeBasedKeyValueStore = null;
        String[] result = new String[input.length];
        for (int i =0; i < input.length;i++) {
            String in = input[i];
            List<String> listDetails = list.get(i);
            result[i] = null;
            switch (in) {
                case "TimeMap" :
                    timeBasedKeyValueStore = new TimeBasedKeyValueStore();
                    break;
                case "set" :
                    timeBasedKeyValueStore.set(listDetails.get(0),listDetails.get(1), Integer.parseInt(listDetails.get(2)));
                    break;
                case "get" :
                    result[i] = timeBasedKeyValueStore.get(listDetails.get(0), Integer.parseInt(listDetails.get(1)));
                    break;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    HashMap<String,HashMap<Integer,String>> keyTimeStamp;
    public TimeBasedKeyValueStore() {
        keyTimeStamp = new HashMap<String,HashMap<Integer,String>>();
    }

    public void set(String key, String value, int timestamp) {
        if(!keyTimeStamp.containsKey(key)) {
            keyTimeStamp.put(key, new HashMap<Integer,String>());
        }

        keyTimeStamp.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!keyTimeStamp.containsKey(key)) {
            return "";
        }

        for(int currTime = timestamp; currTime >= 1; --currTime) {
            if(keyTimeStamp.get(key).containsKey(currTime)) {
                return keyTimeStamp.get(key).get(currTime);
            }
        }

        return "";
    }


}




