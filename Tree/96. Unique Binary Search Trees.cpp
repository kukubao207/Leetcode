96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

思路
设要求的值为G[n],即由1-n结点构成的BST最多有G[n]颗。
设F[i,n]为以i为根节点的BST的总数

G[n]=F[1,n]+F[2,n]+F[3,n]+...+F[n,n]

考虑F[3,5]这种情况,以3为根节点，那么左边的序列为[1,2],右边的序列为[4,5]
F[3,5]就转换成了求左边的序列能构成BST的最大数目 乘以 右边的序列能够成BST的最大数目 的问题
而求解右边的[4,5]其实等价于求解G[2]
因此最后F[3,5]=G[2]*G[2]

同理有
F[1,5]=G[0]*G[4]
F[2,5]=G[1]*G[3]
F[3,5]=G[2]*G[2]
F[4,5]=G[3]*G[1]
F[5,5]=G[4]*G[0]
最后推导出公式

G[n]=G[0]*G[n-1]+G[1]*G[n-2]+...+G[n-1]*G[0]

如何理解G[0]?
思考一下 对于F[1,5]来说，左子树只能为空，右子树是[2,3,4,5]序列构成BST的问题
在这个条件下考虑,G[0]=1,左右相乘的时候就能得到正确答案.
G[0]是不具备含义的,只是为了这个算法的正确性而设计的一个值.

代码
class Solution {
public:
    int numTrees(int n) {
        int G[1000]={0};
        G[0]=G[1]=1;
        for(int i=2;i<=n;i++)
            for(int j=1;j<=i;j++)
                G[i]+=G[i-j]*G[j-1];
        return G[n];
    }
};
