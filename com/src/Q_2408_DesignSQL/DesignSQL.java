package Q_2408_DesignSQL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SQL {
    private final Map<String, Map<Integer, List<String>>> database;
    private final Map<String, Integer> tableIdMap;

    public SQL(List<String> tableNames, List<Integer> columns) {
        this.database = new HashMap<>();
        this.tableIdMap = new HashMap<>();
        for (String name : tableNames) {
            database.put(name, new HashMap<>());
            tableIdMap.put(name, 1);
        }
    }

    public void insertRow(String tableName, List<String> row) {
        // Select the table
        Map<Integer, List<String>> table = this.database.get(tableName);
        // Insert row in the table
        table.put(tableIdMap.get(tableName), row);
        // Increment rowId for the table
        tableIdMap.put(tableName, tableIdMap.get(tableName) + 1);
    }

    public void deleteRow(String tableName, int rowId) {
         // Select the table
         Map<Integer, List<String>> table = this.database.get(tableName);
         // Delete the row against the rowId
         table.remove(rowId);
    }

    public String selectCell(String tableName, int rowId, int columnId) {
        // Select the table
        Map<Integer, List<String>> table = this.database.get(tableName);
        // Select row
        List<String> row = table.get(rowId);
        // Select column
        return row.get(columnId - 1);
    }
}

public class DesignSQL {
    public static void main(String[] args) {
        List<String> tableNames = Arrays.asList("one", "two", "three");
        List<Integer> columns = Arrays.asList(2, 3, 1);
        SQL sql = new SQL(tableNames,columns);
        sql.insertRow("two",Arrays.asList("first", "second", "third"));
        System.out.println(sql.selectCell("two",1,3));
        sql.insertRow("two",Arrays.asList("fourth", "fifth", "sixth"));
        sql.deleteRow("two", 1);
        System.out.println(sql.selectCell("two", 2, 2));
    }
}
