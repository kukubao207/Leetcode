package LinkedList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// 146. LRU Cache
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//The cache is initialized with a positive capacity.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
public class LRUCache {
    //LinkedHashMap  HashMap + LinkedList 即它既使用HashMap操作数据结构，又使用LinkedList维护插入元素的先后顺序
    //使用LinkedHashMap，保持插入顺序
    //一旦被某个entry被get或者put过，就将它放在队尾
    //这样写   LinkedHashMap自己会扩容
//    private LinkedHashMap<Integer, Integer> linkedHashMap;
//    public LRUCache(int capacity) {
//        linkedHashMap = new LinkedHashMap(capacity, 1, true);
//    }
//    public int get(int key) {
//        return linkedHashMap.getOrDefault(key, -1);
//    }
//    public void put(int key, int value) {
//        linkedHashMap.put(key, value);
//    }

    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);//先删除
            //保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        }else if(map.size() >= capacity){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();//把最开头的entry删除（最近最少使用）
        }
        map.put(key, value);
    }

}
