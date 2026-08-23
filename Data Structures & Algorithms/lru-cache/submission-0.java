class  Node {
        int key;
        int value;
        Node next;
        Node prev ;
        Node(){};
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
class LRUCache {

        Node  head;
        Node tail;
        int capacity;
        HashMap<Integer, Node> map = new HashMap<>();
        public LRUCache( int capacity) {
            this.capacity = capacity;
             head = new Node();
             tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void insertFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev =  node;
            head.next = node;
        }

        public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }else {
            Node node = map.get(key);
            remove(node);
            insertFront(node);
            return node.value;
        }
        }

        public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertFront(node);
        }    else {
            if (map.size() == capacity){
                Node node = tail.prev;
                remove(node);
                map.remove(node.key);
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                insertFront(newNode);
            }else {
                Node node = new Node(key, value);
                map.put(key, node);
                insertFront(node);
            }
        }
        }
}
