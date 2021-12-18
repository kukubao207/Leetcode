import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);       // returns 1
        System.out.println(i);

        cache.put(3, 3);    // evicts key 2
        i = cache.get(2);       // returns -1 (not found)
        System.out.println(i);
        cache.put(4, 4);    // evicts key 1
        i = cache.get(1);       // returns -1 (not found)
        System.out.println(i);

        i = cache.get(3);       // returns 3
        System.out.println(i);

        i = cache.get(4);       // returns 4
        System.out.println(i);

    }

    public class Node {
        Node next;
        Node prev;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public void addToHead(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void deleteNode(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
//        node.prev = null;
//        node.next = null;//方便回收
    }
    Map<Integer, Node> map;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    private int nodeCount = 0;
    private int capacity = 0;

    public LRUCache(int capacity) {
        map = new ConcurrentHashMap<>();
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
    }


    public int get(int key) {
        if(map.get(key)!=null){
            Node cur = map.get(key);
            deleteNode(cur);
            addToHead(cur);
            return cur.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node cur = map.get(key);
            deleteNode(cur);
            addToHead(cur);
            cur.value=value;
        }else{
            Node newNode = new Node(key,value);
            addToHead(newNode);
            map.put(key,newNode);
            if(nodeCount>=capacity){
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }else{
                nodeCount++;
            }
        }
    }
}
