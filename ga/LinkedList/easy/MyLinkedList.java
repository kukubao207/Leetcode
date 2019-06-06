package LinkedList.easy;
//707. 设计链表
//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
//在链表类中实现这些功能：
//
//get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
//deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
//
//
//示例：
//
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
//
//
//提示：
//
//所有值都在 [1, 1000] 之内。
//操作次数将在  [1, 1000] 之内。
//请不要使用内置的 LinkedList 库。
public class MyLinkedList {
    /** Initialize your data structure here. */
    ListNode node;
    int length;
    public MyLinkedList() {
        length = 0;
        node = new ListNode(-1);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length || index < 0)
            return -1;
        ListNode cur = node;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode head = new ListNode(val);
        head.next = node.next;
        node.next = head;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = node;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        cur.next.next = null;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length)
            return;
        else if(index == length)
            addAtTail(val);
        else{
            if(index < 0)
                index = index + length + 1;
            ListNode cur = node;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length)
            return;
        else{
            ListNode cur = node;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        length--;
    }

    public class ListNode
    {
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }
}
