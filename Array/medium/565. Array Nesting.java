565. Array Nesting

A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

题意
给定一个数组，数组中的每一个元素都是一个下标，下标指的是该元素的下一个元素的下标，可以理解为类似于链表的结构。
求出最长的一条链。

我的思路
深度优先搜索，每搜索一个结点，标记该节点为1.
如果遇到结点已访问过，返回该节点对应链的长度。
回溯时保存该节点对应链的长度。

我的代码
class Solution {
    public int arrayNesting(int[] nums) {
        int N=nums.length;
        vis = new int[N];
        S = new int[N];
        Arrays.fill(vis,0);
        Arrays.fill(S,0);
        for(int i=0;i<N;i++){
            if(vis[i]==1)
                continue;
            dfs(i,nums);
        }
        return maxLength;
    }
    int vis[], S[], maxLength=0;
    int dfs(int index,int[] nums){
        if(vis[index]==1)
            return S[index];
        vis[index]=1;
        S[index]=dfs(nums[index],nums)+1;
        maxLength = Math.max(S[index],maxLength);
        return S[index];
    }
}

别人的思路
The idea is to, start from every number, find circles in those index-pointer-chains, 
every time you find a set (a circle) ，
mark every number as visited (-1) so that next time you won't step on it again.

public class Solution {
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}