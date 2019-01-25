import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.List;

public class SortedStringTable {
    private final BloomFilter<String> bloomFilter;

    private List<Column> columns;

    public final static int MAX_CAPACITY = 1024;
    private final int capacity = MAX_CAPACITY;
    private int size = 0;

    private final int pageSize;

    // TODO: support compression on disk level
    // private final boolean compressed;

    private SortedStringTable(double fpp, int pageSize, int level, String tableName, int tableId) {
        bloomFilter = BloomFilter.create(Funnels.unencodedCharsFunnel(), this.capacity, fpp);

        this.pageSize = pageSize;

        String fileName = tableName + "__sstable__" + level + "__" + tableId + ".sst";
    }
}
