547. Friend Circles

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.

题意
给定一系列朋友对，判断有多少个朋友圈。

我的思路
非常简单的并查集思路，把每个有关系的朋友对Union在一起，组成一颗树。
这样最后判断有多少颗树，就知道有多少个朋友圈了。
判断多少颗树的方法在于，通过parent[]数组得出根节点的数目。

class Solution {
    int Find(int x){
        while(x!=parent[x])
            x=parent[x];
        return x;
    }
    int parent[];
    public int findCircleNum(int[][] M) {
        parent=new int[M.length];
        for(int i=0;i<M.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M.length;j++){
                if(M[i][j]==1){
                    int pi=Find(i),pj=Find(j);
                    if(pi!=pj){
                        parent[pj]=pi;
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<M.length;i++)
            if(parent[i]==i)
                count++;
        return count;
    }
}