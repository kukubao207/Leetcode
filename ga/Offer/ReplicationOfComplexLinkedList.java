package Offer;

/**复杂链表的额复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ReplicationOfComplexLinkedList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode head1 = pHead;
        while (head1 != null) {
            RandomListNode next = head1.next;
            head1.next = new RandomListNode(head1.label);
            head1.next.next = next;
            head1 = head1.next.next;
        }
        RandomListNode head2 = pHead;
        while (head2 != null) {
            if (head2.random == null)
                head2.next.random = null;
            else
                head2.next.random = head2.random.next;
            head2 = head2.next.next;
        }
        RandomListNode head3 = pHead;
        RandomListNode node = head3.next;
        RandomListNode res = node;
        while (head3 != null) {
            head3.next = head3.next.next;
            head3 = head3.next;
            if (head3 == null)
                node.next = null;
            else {
                node.next = head3.next;
                node = node.next;
            }
        }
        return res;
    }
}
