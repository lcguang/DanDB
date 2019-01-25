import java.util.Map;

public class Row {
    private Map<String, String> row;

    private Row(Map<String, String> row) {
        this.row = row;
    }

    public static Row fromMap(Map<String, String> row) {
        return new Row(row);
    }

    public String put(String key, String value) {
        return row.put(key, value);
    }

    public String get(String key) {
        return row.get(key);
    }

    public String remove(String key) {
        return row.remove(key);
    }
}
