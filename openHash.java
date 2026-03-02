public class openHash {

    private String[] keys;
    private String[] values;
    private int m;
    private int size;

    // Constructor
    public openHash(int m) {
        this.m = m;
        keys = new String[m];
        values = new String[m];
        size = 0;
    }

    // (a) Hash function
    public int hash(String key) {
        return Math.abs(key.hashCode()) % m;
    }

    // (b) Insert
    public void insert(String key, String value) {

        if (isFull())
            return;

        int i = hash(key);

        while (keys[i] != null) {
            i = (i + 1) % m;   // linear probing
        }

        keys[i] = key;
        values[i] = value;
        size++;
    }

    // (c) Lookup
    public String lookup(String key) {

        int i = hash(key);

        while (keys[i] != null) {

            if (keys[i].equals(key))
                return values[i];

            i = (i + 1) % m;
        }

        return null;
    }

    // (d) Remove
    public String remove(String key) {

        int i = hash(key);

        while (keys[i] != null) {

            if (keys[i].equals(key)) {
                String val = values[i];

                keys[i] = null;
                values[i] = null;
                size--;

                return val;
            }

            i = (i + 1) % m;
        }

        return null;
    }

    // (e) Predicates
    public boolean isFull() {
        return size == m;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isInTable(String key) {
        return lookup(key) != null;
    }
}
