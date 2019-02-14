45. Jump Game II
        Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.

        Your goal is to reach the last index in the minimum number of jumps.

        Example:

        Input: [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2.
        Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Note:

        You can assume that you can always reach the last index.

我的思路
class Solution {
    public int jump(int[] nums) {
        int[] step = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            step[i]=-1;
        step[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int k=1;k<=nums[i]&&i+k<nums.length;k++){
                if(step[i+k]!=-1)
                    step[i+k]=Math.min(step[i+k],step[i]+1);
                else
                    step[i+k]=step[i]+1;
            }
        }
        return step[nums.length-1];
    }
}

贪心思路
核心在于理解，什么时候必须进行一次跳转
curEnd代表上一次跳转的最后一个位置，
当i遍历到curEnd，说明不得不jump了，这时候跳出最远的一步。
class Solution {
    public int jump(int[] nums) {
        int jump=0,curEnd=0,curFartest=0;
        for(int i=0;i<nums.length&&curEnd<nums.length-1;i++){
            curFartest = Math.max(curFartest,i+nums[i]);
            if(i==curEnd){
                jump++;
                curEnd=curFartest;
            }
        }
        return jump;
    }
}

I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump. for example. 2 3 1 1 4 , is

        2||
        3 1||
        1 4 ||

        clearly, the minimum jump of 4 is 2 since 4 is in level 3. my ac code.

int jump(int A[], int n) {
    if(n<2)
        return 0;
    int level=0,currentMax=0,i=0,nextMax=0;
    while(currentMax-i+1>0){		//nodes count of current level>0
        level++;
        for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
            nextMax=max(nextMax,A[i]+i);
            if(nextMax>=n-1)
                return level;   // if last element is in level+1,  then the min jump=level
        }
        currentMax=nextMax;
    }
    return 0;
}