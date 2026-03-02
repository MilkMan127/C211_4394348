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
