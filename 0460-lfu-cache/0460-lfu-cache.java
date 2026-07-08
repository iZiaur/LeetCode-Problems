
import java.util.HashMap;
import java.util.Map;

class LFUCache {
    
    class Node {
        int key, value, freq;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    class DoublyLinkedList {
        Node head, tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }
        
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeTail() {
            if (size > 0) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                return lruNode;
            }
            return null;
        }
    }

    private final int capacity;
    private int curSize;
    private int minFreq;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (curSize == capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node deletedNode = minFreqList.removeTail();
                cache.remove(deletedNode.key);
                curSize--;
            }
            
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1;
            DoublyLinkedList list = freqMap.computeIfAbsent(1, k -> new DoublyLinkedList());
            list.addNode(newNode);
            curSize++;
        }
    }
    
    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);
        
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        
        node.freq++;
        DoublyLinkedList newList = freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
        newList.addNode(node);
    }
}

