ublic class chainedHash {

    // Node for linked list
    private class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int m;      // table size
    private int size;   // number of key-value pairs

    // Constructor
    public chainedHash(int m) {
        this.m = m;
        table = new Node[m];
        size = 0;
    }
    public int hash(String key) {
        return Math.abs(key.hashCode()) % m;
    }

    // Insert
    public void insert(String key, String value) {

        int i = hash(key);

        Node current = table[i];

        // If list empty → insert at beginning
        if (current == null) {
            table[i] = new Node(key, value);
            size++;
            return;
        }

        // Otherwise search list
        Node prev = null;

        while (current != null) {

            if (current.key.equals(key)) {
                current.value = value;  // update
                return;
            }
