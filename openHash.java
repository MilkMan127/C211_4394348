public class openHash {

    private String[] keys;
    private String[] values;
    private int m;          // table size
    private int size;       // number of elements stored

    // Constructor
    public openHash(int tableSize) {
        m = tableSize;
        keys = new String[m];
        values = new String[m];
        size = 0;
    }
