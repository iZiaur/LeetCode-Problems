class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            next=prev=null;
        }
    }
    HashMap<Integer,Node> map;
    int limit;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
       map=new HashMap<>();
       limit=capacity;
       head=new Node(-1,-1);
       tail=new Node(-1,-1);
       head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode){
        Node oldnext=head.next;
        head.next=newNode;
        oldnext.prev=newNode;
        newNode.next=oldnext;
        newNode.prev=head;
    }

    public void deleteNode(Node oldNode){
        Node oldprevious=oldNode.prev;
        Node oldnext=oldNode.next;
        oldprevious.next=oldnext;
        oldnext.prev=oldprevious;
    }
    
    public int get(int key) {
       if(!map.containsKey(key)){
        return -1;
       }
       Node ansNode=map.get(key);
       int ans=ansNode.value;
       map.remove(key);
       deleteNode(ansNode);
       addNode(ansNode);
       map.put(key,ansNode);
       return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode=map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }
        if(map.size()==limit){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);

        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */