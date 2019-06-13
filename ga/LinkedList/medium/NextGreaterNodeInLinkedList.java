package LinkedList.medium;
// 1019. 链表中的下一个更大节点
//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
//
//每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
//
//返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
//
//注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
//
// 
//
//示例 1：
//
//输入：[2,1,5]
//输出：[5,5,0]
//示例 2：
//
//输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
//示例 3：
//
//输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
// 
//
//提示：
//
//对于链表中的每个节点，1 <= node.val <= 10^9
//给定列表的长度在 [0, 10000] 范围内
//

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    //1.动态规划，先遍历一遍链表，将所有值存储到数组中，反向遍历数组，设 dp[i] 值为索引 i 时的下一个最大值，则 dp 推进公式为：
    //if nums[i + 1] > nums[i] then dp[i] = nums[i + 1]
    //if nums[i + 1] == nums[i] then dp[i] = dp[i + 1]
    //else dp[i] = { 遍历 dp[i + 1] ... dp[n]，寻找最近大于 nums[i] 的值，遇到 0 停止遍历，遇到 0 表示后面没有更大的值了 }
    public int[] nextLargerNodes(ListNode head) {
        List list = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int[] dp = new int[size];//最后一个元素肯定是0
        for(int i = size - 2; i >= 0;i--){
            if((int)list.get(i + 1) > (int)list.get(i))
                dp[i] = (int)list.get(i + 1);
            else if((int)list.get(i + 1) == (int)list.get(i))
                dp[i] = dp[i + 1];
            else{
                for(int j = i + 1; j < size; j++){
                    if(dp[j] > (int)list.get(i) || dp[j] == 0){
                        dp[i] = dp[j];
                        break;
                    }
                }
            }
        }
        return dp;
    }

    //使用栈
    //固定一个数b，往前看（存入栈中），哪一个数a小于这个数b（小于就删除），即a的下一个更大节点为b
    public int[] nextLargerNodes1(ListNode head) {
        List list = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int[] res = new int[size];//最后一个元素肯定是0
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && (int)list.get(stack.peek()) < (int)list.get(i)){
                res[stack.pop()] = (int)list.get(i);
            }
            stack.push(i);
        }
        return res;
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
