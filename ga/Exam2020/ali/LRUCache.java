package Exam2020.ali;

//设计一个LRU Cache，即根据LRU算法设计一个缓存，它支持两个操作：
//        1）get(key)：如果key在cache中，则返回对应的value值，否则返回-1
//        2）set(key,value):如果key不在cache中，则将该(key,value)插入cache中
//        （注意，如果cache已满，则必须把最近最久未使用的元素从cache中删除）；如果key在cache中，则重置value的值

import java.util.HashMap;
import java.util.Map;


//循环链表(记录插入顺序，头部是最久未被访问 尾部是刚被访问)+hashmap
public class LRUCache {
    public static void main(String[] args) {
        test();
    }

    int cap;
    Node head;
    Node tail;
    Map map;

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public LRUCache(int cap) {
        this.cap = cap;
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, null, null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    //越靠近tail是刚刚被操作的节点
    public void addTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        Node node = (Node) map.get(key);
        //已经被访问过 所以要先删除 再放到尾部去
        if (node != null) {
            delete(node);
            addTail(node);
        }
        return node == null ? -1 : node.value;
    }

    public void set(int key, int value) {
        //1.先重置value
        //2.被访问过 所以要先删除 再放到尾部去
        if (map.containsKey(key)) {
            Node node = (Node) map.get(key);
            node.value = value;
            delete(node);
            addTail(node);
        } else {//新值
            //先判断容量有没有超
            if (map.size() >= cap) {//删掉最近最久未使用的元素（也就是头结点的后一个元素）
                //删掉map里面的元素结构
                map.remove(head.next.key);
                delete(head.next);//链表里面的元素结构也要删除
            }
            //容量没有超
            Node node = new Node(key, value, null, null);
            map.put(key, node);
            addTail(node);//刚被访问过 所以要放在尾部
        }
    }

    public static void test() {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1)); // return 1
        cache.set(3, 3);
        System.out.println(cache.get(2)); //return -1
        cache.set(4, 4);
        System.out.println(cache.get(1)); //return -1
        System.out.println(cache.get(3)); //return 3
        System.out.println(cache.get(4)); //return 4
    }

}