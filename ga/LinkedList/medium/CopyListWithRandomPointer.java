package LinkedList.medium;

import java.util.HashMap;
import java.util.Map;

//138. 复制带随机指针的链表
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//
//要求返回这个链表的深拷贝。
//
//
//
//示例：
//
//
//
//输入：
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//
//解释：
//节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
//节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
public class CopyListWithRandomPointer {
    //1.使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<Node, Node> map = new HashMap<>();
        while(node != null){
            Node clone = new Node(node.val, null, null);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    //2.原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表
    public Node copyRandomList1(Node head) {
        if(head == null)
            return null;
        Node node = head;
        //空间复杂度O(1)，将克隆结点放在原结点后面
        //// 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            Node clone = new Node(node.val, node.next, null);
            Node tmp = node.next;
            node.next = clone;
            node= tmp;
        }
        //处理random指针
        node = head;
        while(node != null){
            if(node.random != null)
                node.random = node.random.next;
//            node.next.random = node.random == null ? null : node.random.next;//random.next才是clone出来的random
            node.next.random = node.random;
            node = node.next.next;
        }
        //还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }
        return cloneHead;
    }



    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

}

