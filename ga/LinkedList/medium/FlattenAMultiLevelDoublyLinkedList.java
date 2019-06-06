package LinkedList.medium;

import java.util.Stack;

//430. 扁平化多级双向链表
//您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
//
//扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
//
//
//
//示例:
//
//输入:
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//
//输出:
//1-2-3-7-8-11-12-9-10-4-5-6-NULL
//
//
//以上示例的说明:
//
//给出以下多级双向链表:
//
//
//
//
//我们应该返回如下所示的扁平双向链表:
public class FlattenAMultiLevelDoublyLinkedList {

    //栈存储
//    1.遍历
//    2.没有child就跳next
//    3.有child就把next压栈，修改自身next和child的prev，然后跳child
//    4.重复2，3，直到没有next执行5
//    5.出栈获取当前层上一层的中断点，将其与当前层的尾节点连上
//    6.重复2，3，4，5直到next为null，栈为空
//    循环条件 while (遍历指针不为null && ( 遍历指针存在next || 遍历指针存在child || 栈长度>0 ))
    public Node flatten(Node head) {
        if(head == null)
            return head;
        if(head.next == null && head.child == null)
            return  head;
        Node cur = head;
        Stack<Node> nexts = new Stack<>();
        while(cur.next != null || cur.child != null || !nexts.isEmpty()){
            if(cur.child != null){
                if(cur.next != null){//如果有next保存在栈里
                    nexts.push(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            if (cur.next == null && cur.child == null && !nexts.isEmpty()){//开始拿栈的数据
                Node next = nexts.pop();
                cur.next = next;
                next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //递归
    public Node flatten1(Node head) {
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                Node child = flatten1(cur.child);
                cur.child = null;
                if(cur.next == null){
                    cur.next = child;
                    child.prev = cur;
                }else{//如果有next
                    Node tail = child;
                    while(tail.next != null){
                        tail = tail.next;
                    }
                    tail.next = cur.next;
                    cur.next.prev = tail;
                    cur.next = child;
                    child.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}
