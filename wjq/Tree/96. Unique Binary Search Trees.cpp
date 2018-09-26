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

˼·
��Ҫ���ֵΪG[n],����1-n��㹹�ɵ�BST�����G[n]�š�
��F[i,n]Ϊ��iΪ���ڵ��BST������

G[n]=F[1,n]+F[2,n]+F[3,n]+...+F[n,n]

����F[3,5]�������,��3Ϊ���ڵ㣬��ô��ߵ�����Ϊ[1,2],�ұߵ�����Ϊ[4,5]
F[3,5]��ת����������ߵ������ܹ���BST�������Ŀ ���� �ұߵ������ܹ���BST�������Ŀ ������
������ұߵ�[4,5]��ʵ�ȼ������G[2]
������F[3,5]=G[2]*G[2]

ͬ����
F[1,5]=G[0]*G[4]
F[2,5]=G[1]*G[3]
F[3,5]=G[2]*G[2]
F[4,5]=G[3]*G[1]
F[5,5]=G[4]*G[0]
����Ƶ�����ʽ

G[n]=G[0]*G[n-1]+G[1]*G[n-2]+...+G[n-1]*G[0]

������G[0]?
˼��һ�� ����F[1,5]��˵��������ֻ��Ϊ�գ���������[2,3,4,5]���й���BST������
����������¿���,G[0]=1,������˵�ʱ����ܵõ���ȷ��.
G[0]�ǲ��߱������,ֻ��Ϊ������㷨����ȷ�Զ���Ƶ�һ��ֵ.

����
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
