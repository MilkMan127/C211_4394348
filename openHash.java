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
 public int hash(String key) {

        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % m;
        }

        return Math.abs(hash);
    }
    public void insert(String key, String value) {

        if (isFull())
            return;

        int i = hash(key);

        // Linear probing
        while (keys[i] != null && !keys[i].equals("DELETED")) {

            if (keys[i].equals(key)) {
                values[i] = value; // update existing
                return;
            }

            i = (i + 1) % m;
        }

        keys[i] = key;
        values[i] = value;
        size++;
    }
    public String lookup(String key) {

        int i = hash(key);
        int start = i;

        while (keys[i] != null) {

            if (keys[i].equals(key))
                return values[i];

            i = (i + 1) % m;

            if (i == start)
                break;
        }

        return null;
    }
 public String remove(String key) {

        int i = hash(key);
        int start = i;

        while (keys[i] != null) {

            if (keys[i].equals(key)) {
                String val = values[i];

                keys[i] = "DELETED";  // mark as deleted
                values[i] = null;
                size--;

                return val;
            }

            i = (i + 1) % m;

            if (i == start)
                break;
        }

        return null;
    }

