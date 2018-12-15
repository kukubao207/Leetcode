Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

        Note:
        Each of the array element will not exceed 100.
        The array size will not exceed 200.
        Example 1:

        Input: [1, 5, 11, 5]

        Output: true

        Explanation: The array can be partitioned as [1, 5, 5] and [11].
        Example 2:

        Input: [1, 2, 3, 5]

        Output: false

        Explanation: The array cannot be partitioned into equal sum subsets.

给定一个数组，将其拆分成两个数组，使其这两个子数组和相等。
这个问题其实和 从一个数组中找出一个子数组，和为target的题类似，只不过这题target=sum/2。

这可以理解为一个01背包的问题，数组中的数可以看成是某个物品的重量，也是某个物品的价值,target是背包的大小。

先看优化前的dp（C++代码）
class Solution {
    public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int target = sum/2,n=nums.size();
        //dp[i][j]表示 从前i个元素中挑选任意个元素的和 能否 组成j
        bool dp[n+1][target+1];

        //初始化dp数组
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                dp[i][j]=false;
            }
        }
        //显然前i个元素挑选0个元素就可以组成0
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            int num = nums[i-1];
            for(int j=1;j<target+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=num&&dp[i-1][j-num]==true){
                    dp[i][j]=dp[i-1][j-num];
                }
            }
        }
        return dp[n][target];
    }
};

空间优化后（c++）
class Solution {
    public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        int n=nums.size();

        //dp[i]表示 从原数组中挑选任意个元素的和 能否 组成i
        bool dp[target+1];
        memset(dp,false,sizeof(dp));
        dp[0]=true;
        for(int i=0;i<n;i++){
            int num = nums[i];
            for(int j=target;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[target];
    }
};


