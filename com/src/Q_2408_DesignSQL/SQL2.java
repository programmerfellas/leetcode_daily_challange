package Q_2408_DesignSQL;

import java.util.*;

public class SQL2 {
    Map<String, LinkedHashMap<Integer, ArrayList<String>>> tables;
    Map<String, Integer> primeryKeyMap;

    public SQL2(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        primeryKeyMap = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            tables.put(names.get(i), new LinkedHashMap<Integer, ArrayList<String>>());
            primeryKeyMap.put(names.get(i), 1);
        }
    }

    public void insertRow(String name, List<String> row) {
        LinkedHashMap<Integer, ArrayList<String>> table = tables.get(name);
        int key = primeryKeyMap.get(name);
        primeryKeyMap.put(name, key + 1);
        table.put(key, new ArrayList<String>(row));
    }

    public void deleteRow(String name, int rowId) {
        tables.get(name).remove(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        // subtract coulumnID by 1 as list start with 0th index
        return tables.get(name).get(rowId).get(columnId - 1);
    }

    public static void main(String[] args) {
        List<String> tableNames = Arrays.asList("one", "two", "three");
        List<Integer> columns = Arrays.asList(2, 3, 1);
        SQL2 sql = new SQL2(tableNames,columns);
        sql.insertRow("two",Arrays.asList("first", "second", "third"));
        System.out.println(sql.selectCell("two",1,3));
        sql.insertRow("two",Arrays.asList("fourth", "fifth", "sixth"));
        sql.deleteRow("two", 1);
        System.out.println(sql.selectCell("two", 2, 2));
    }
}