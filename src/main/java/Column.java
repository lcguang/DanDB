public class Column {
    private final String colKey;
    private Row rowMap;

    public final static int MAX_CAPACITY = 1024;
    private final int capacity = MAX_CAPACITY;
    private int size = 0;

    private boolean tombstone = false;

    private Column(String colKey, Row rowMap, boolean tombstone) {
        this.colKey = colKey;
        this.rowMap = rowMap;
        this.tombstone = tombstone;
    }

    public static Column fromParams(String colKey, Row rowMap, boolean tombstone) {
        return new Column(colKey, rowMap, tombstone);
    }

    public static Column fromOther(Column other) {
        return new Column(other.colKey, other.rowMap, other.tombstone);
    }

    public String put(String rowKey, String value) {
        if (size >= capacity) {
            // TODO: throw an exception
            System.out.println("Out of capacity");
            return null;
        }

        String previousValue = rowMap.put(rowKey, value);
        ++size;

        return previousValue;
    }

    public String get(String rowKey) {
        return rowMap.get(rowKey);
    }

    public String remove(String rowKey) {
        String value = rowMap.remove(rowKey);
        if (value != null) {
            --size;
        }

        return value;
    }
}
